package com.Bgrupo4.hospitalupskill.user.utente;


import com.Bgrupo4.hospitalupskill.consultas.ConsultasService;
import com.Bgrupo4.hospitalupskill.consultas.Status;
import com.Bgrupo4.hospitalupskill.consultas.appointment.Appointment;
import com.Bgrupo4.hospitalupskill.consultas.receitas.Receita;
import com.Bgrupo4.hospitalupskill.consultas.receitas.ReceitaService;
import com.Bgrupo4.hospitalupskill.consultas.relatorio.Relatorio;
import com.Bgrupo4.hospitalupskill.consultas.relatorio.RelatorioRepository;
import com.Bgrupo4.hospitalupskill.registration.email.EmailSender;
import com.Bgrupo4.hospitalupskill.registration.EmailValidator;
import com.Bgrupo4.hospitalupskill.registration.RegistrationService;
import com.Bgrupo4.hospitalupskill.security.PasswordEncoder;
import com.Bgrupo4.hospitalupskill.senha.Senha;
import com.Bgrupo4.hospitalupskill.senha.SenhaService;
import com.Bgrupo4.hospitalupskill.user.ApplicationUserService;
import com.Bgrupo4.hospitalupskill.user.employee.EmployeeRequest;
import lombok.RequiredArgsConstructor;
import org.checkerframework.checker.nullness.Opt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityNotFoundException;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@Service
@RequiredArgsConstructor
public class UtenteService {

    private final static String USER_NOT_FOUND_MSG = "O utente %s não foi encontrado";

    @Autowired
    private final UtenteRepository utenteRepository;
    private final EmailValidator emailValidator;
    private final ApplicationUserService applicationUserService;
    private final EmailSender emailSender;
    private final RegistrationService registrationService;
    private final ConsultasService consultasService;
    private final ReceitaService receitaService;
    private final RelatorioRepository relatorioRepository;
    private final SenhaService senhaService;


    public Optional<Utente> getUserById(Long id) {
        return utenteRepository.findById(id);
    }

    public Optional<Utente> getUserByUsername(String username) {
        return utenteRepository.findByUsername(username);
    }


    public List<Utente> getAllUtentes() {
        return utenteRepository.findAll();
    }

    public Utente getLogged(Authentication auth) throws Exception {
        String principal = auth.getPrincipal().toString();
        String[] split = principal.split("username='");
        String[] split2 = split[1].split("',");
        Optional<Utente> utente = getUserByUsername(split2[0]);
        if (utente.isEmpty()){
            throw new Exception("There's no logged person");
        }
        return utente.get();
    }


    public void registerUtente(UtenteRegistrationRequest request) {
        System.out.println("inside the register 1");
        boolean isValidEmail = emailValidator.test(request.getEmail());
        if (!isValidEmail) {
            throw new IllegalStateException("email not valid");
        }
        System.out.println("inside the register 2");
        //Todo we should check the request before doing the user cause it gives error if the user is not complete
        String[] data = request.getDataDeNascimento().split("-");
        String token = applicationUserService.singUpUser(new Utente(
                request.getNif(),
                request.getName(),
                request.getUsername(),
                request.getEmail(),
                request.getPassword(),
                request.getMorada(),
                request.getLocalidade(),
                request.getTelemovel(),
                new GregorianCalendar(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2])),
                request.getApolice(),
                request.getNumUtente()));
        String link = "http://localhost:8080/utente/register/confirm?token=" + token;
        emailSender.senad(request.getEmail(), registrationService.buildEmail(request.getName(), link));
    }

    public Utente updateUtente(Long id, UtenteRequest request) {
        Optional<Utente> utente = utenteRepository.findById(id);
        if (!utente.isPresent()) {
            throw new EntityNotFoundException(String.format("Utente %s não foi encontrado", id));
        }
        Utente utente1 = utente.get();
        if (!request.getApolice().isEmpty()){
            utente1.setApolice(request.getApolice());
        }
        if (!request.getLocalidade().isEmpty()){
            utente1.setLocalidade(request.getLocalidade());
        }
        if (!request.getMorada().isEmpty()){
            utente1.setMorada(request.getMorada());
        }
        if (!request.getTelemovel().isEmpty()){
            utente1.setPhone(request.getTelemovel());
        }
        return utenteRepository.save(utente1);
    }
    public Utente updateUtente(Utente utente, UtenteUpdateRequest request) {
       // if ( passwordEncoder.bCryptPasswordEncoder().encode(request.getPassword()).matches(utente.getPassword())){
            if (!request.getApolice().isEmpty()){
                utente.setApolice(request.getApolice());
            }
            if (!request.getLocalidade().isEmpty()){
                utente.setLocalidade(request.getLocalidade());
            }
            if (!request.getMorada().isEmpty()){
                utente.setMorada(request.getMorada());
            }
            if (!request.getTelemovel().isEmpty()){
                utente.setPhone(request.getTelemovel());
            }
            if (!request.getName().isEmpty()){
                utente.setName(request.getName());
            }

            return utenteRepository.save(utente);
        //}
        //throw new IllegalArgumentException("Palavra passe incorrect");
    }


    public List<Appointment> getAppointments(Utente utente){
        return consultasService.getAppointmentsUtente(utente.getId());
    }

    public Appointment getNextAppointment(Utente utente) {
        List<Appointment> appointment = consultasService.getAppointmentsUtenteOrderByDate(utente);
        if (appointment.isEmpty()){
            throw new EntityNotFoundException(String.format("O utente %s não tem consultas marcadas", utente.getUsername()));
        }
        return appointment.get(0);
    }

    public Receita getLastReceita(Utente utente) {
        List<Receita> receitas = receitaService.getReceitasByUtente(utente.getId());
        if (receitas.isEmpty()){
            throw new EntityNotFoundException(String.format("O utente %s não tem consultas marcadas", utente.getUsername()));
        }
        return receitas.get(receitas.size()-1);
    }

    private List<Receita> getReceitas(Utente utente) {
        return receitaService.getReceitasByUtente(utente.getId());
    }

    public Utente updateUtente(Utente utente, MultipartFile imageFile) throws  Exception{
        String folder = "/imagens/utente/";
        String rootDir = System.getProperty("user.dir");
        Path path = Paths.get(rootDir + folder + imageFile.getOriginalFilename());
        imageFile.transferTo(new File(String.valueOf(path)));
        utente.setProfilePicture(imageFile.getOriginalFilename());
        return utenteRepository.save(utente);
    }

    public List<Receita> getReceitasByUtente(Long id) {
        return receitaService.getReceitasByUtente(id);
    }

    public List<Relatorio> getRelatorioByUtente(Long id) {
        Optional<Utente> utenteOptional = utenteRepository.findById(id);
        if (utenteOptional.isEmpty()){
            throw new EntityNotFoundException("Utente not found: "+ id);
        }
        return relatorioRepository.findAllByUtente(utenteOptional.get());
    }

    public boolean deleteUtente(Long id) {
        Optional<Utente> utenteOptional = utenteRepository.findById(id);
        if (utenteOptional.isEmpty()){
            throw new EntityNotFoundException("Utente not found: "+ id);
        }
        try {
            utenteRepository.delete(utenteOptional.get());
            return true;
        }catch (Exception e){
            return false;
        }

    }

    public Utente updateUtente(Long id, UtenteUpdateRequest request) {
        Optional<Utente> utenteOptional = utenteRepository.findById(id);
        if (utenteOptional.isEmpty()){
            throw new EntityNotFoundException("Utente nao encontrado: "+id);
        }
        Utente utente = utenteOptional.get();
        if (!request.getApolice().isEmpty()){
            utente.setApolice(request.getApolice());
        }
        if (!request.getLocalidade().isEmpty()){
            utente.setLocalidade(request.getLocalidade());
        }
        if (!request.getMorada().isEmpty()){
            utente.setMorada(request.getMorada());
        }
        if (!request.getTelemovel().isEmpty()){
            utente.setPhone(request.getTelemovel());
        }
        if (!request.getName().isEmpty()){
            utente.setName(request.getName());
        }

        return utenteRepository.save(utente);
    }

    public Utente getUserByNif(String nif) {
        return utenteRepository.findByNif(nif);
    }

    public List<Utente> getAllUtentesAEspera() {
        List<Utente> utentes = new ArrayList<>();
        for (Senha se: senhaService.getSenhas()) {
           if (utentes.contains(se.getUtente())){
               continue;
           }
           utentes.add(se.getUtente());
        }
        return utentes;
    }

    public List<Utente> getAllUtentesAtrasados() {
        List<Utente> utentes = new ArrayList<>();
        for (Senha se: senhaService.getSenhasByStatus(Status.LATE.name())) {
            if (utentes.contains(se.getUtente())){
                continue;
            }
            utentes.add(se.getUtente());
        }
        return utentes;
    }

    public List<Utente> getAllUtentesAtendidos() {
        List<Utente> utentes = new ArrayList<>();
        for (Senha se: senhaService.getSenhasAtendidas()) {
            if (utentes.contains(se.getUtente())){
                continue;
            }
            utentes.add(se.getUtente());
        }
        return utentes;
    }
}
