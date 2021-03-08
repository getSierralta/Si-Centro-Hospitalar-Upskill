package com.Bgrupo4.hospitalupskill.user.utente;


import com.Bgrupo4.hospitalupskill.email.EmailSender;
import com.Bgrupo4.hospitalupskill.registration.EmailValidator;
import com.Bgrupo4.hospitalupskill.registration.RegistrationService;
import com.Bgrupo4.hospitalupskill.user.ApplicationUserService;
import com.Bgrupo4.hospitalupskill.user.UserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
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
        String token = applicationUserService.singUpUser(new Utente(
                request.getNif(),
                request.getName(),
                request.getUsername(),
                request.getEmail(),
                request.getPassword(),
                request.getMorada(),
                request.getLocalidade(),
                request.getTelemovel(),
                request.getDataDeNascimento(),
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
        utente1.setName(request.getName());
        utente1.setUsername(request.getUsername());
        utente1.setApolice(request.getApolice());

        return utenteRepository.save(utente1);
    }



}
