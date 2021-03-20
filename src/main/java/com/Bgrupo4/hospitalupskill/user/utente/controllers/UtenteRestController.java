package com.Bgrupo4.hospitalupskill.user.utente.controllers;


import com.Bgrupo4.hospitalupskill.Calendario.EspecialidadeRequest;
import com.Bgrupo4.hospitalupskill.consultas.ConsultasService;
import com.Bgrupo4.hospitalupskill.consultas.appointment.Appointment;
import com.Bgrupo4.hospitalupskill.senha.Senha;
import com.Bgrupo4.hospitalupskill.senha.SenhaService;
import com.Bgrupo4.hospitalupskill.consultas.vaga.Vaga;
import com.Bgrupo4.hospitalupskill.consultas.vaga.VagaService;
import com.Bgrupo4.hospitalupskill.registration.RegistrationService;
import com.Bgrupo4.hospitalupskill.user.utente.Utente;
import com.Bgrupo4.hospitalupskill.user.utente.UtenteRegistrationRequest;
import com.Bgrupo4.hospitalupskill.user.utente.UtenteService;
import com.Bgrupo4.hospitalupskill.user.utente.UtenteUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.mail.Multipart;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/utente")
@RequiredArgsConstructor
public class UtenteRestController {

    private final UtenteService utenteService;
    private final RegistrationService registrationService;
    private final VagaService vagaService;
    private final SenhaService senhaService;
    private final ConsultasService consultasService;
    private final UtenteManagementController utenteManagementController;

    @GetMapping(path = "{id}")
    public Optional<Utente> getUser(@PathVariable("id") Long id){
        return utenteService.getUserById(id);
    }


    @PostMapping(path = "/register", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ModelAndView register( UtenteRegistrationRequest request){
        utenteService.registerUtente(request);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/utente/register");
        return modelAndView;
    }

    @PostMapping(path = "/update", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @PreAuthorize("hasRole('ROLE_UTENTE')")
    public RedirectView update(UtenteUpdateRequest request) throws Exception {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Utente utente = utenteService.getLogged(auth);
        utenteService.updateUtente(utente, request);
        return new RedirectView("/utente/settings");
    }

    @PostMapping(path = "/uploadImage")
    @PreAuthorize("hasRole('ROLE_UTENTE')")
    public RedirectView updateImage(@RequestParam("imageFile") MultipartFile imageFile) throws Exception {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Utente utente = utenteService.getLogged(auth);
        try {
            utenteService.updateUtente(utente, imageFile);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("-------------- eror saving photo");
            return new RedirectView("/500");
        }
        return new RedirectView("/utente/settings");
    }

    @GetMapping(value = "/register")
    public String showConfirmEmail(){
        return "/utente/register";
    }


    @GetMapping(path = "/register/confirm")
    public ModelAndView confirm(@RequestParam("token") String token) {
        ModelAndView modelAndView = new ModelAndView();
        if (registrationService.confirmToken(token)){
            modelAndView.setViewName("/utente/confirm");
        }else {
            modelAndView.setViewName("/pessoa/error");
        }
        return modelAndView;
    }

    @GetMapping(path = "/calendariogeralutente/{especialidade}/{dia}")
    @PreAuthorize("hasAnyRole('ROLE_UTENTE', 'ROLE_MEDICO', 'ROLE_COLABORADOR')")
    public List<Vaga> getVagas(@PathVariable("especialidade") String especialidade, @PathVariable("dia") String dia) {
        return vagaService.getVagas(especialidade, dia);
    }

    @GetMapping(path = "/cancelar/{id}")
    @PreAuthorize("hasRole('ROLE_UTENTE')")
    public ResponseEntity<Appointment> cancelAppoinment(@PathVariable("id") String id) {
        return ResponseEntity.ok(consultasService.cancelAppointment(Long.valueOf(id)));
    }

    @GetMapping(path = "/checkin/{id}")
    @PreAuthorize("hasRole('ROLE_UTENTE')")
    public List<Senha> getSenhaCheckIn(@PathVariable("id") String id) {
        List<Senha> senhas = new ArrayList<>();
        senhas.add(senhaService.createSenha(Long.valueOf(id)));
        return senhas;
    }

    @GetMapping(path = "/check-in")
    @PreAuthorize("hasRole('ROLE_UTENTE')")
    public List<Senha> getSenha() throws Exception {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Utente utente = utenteService.getLogged(auth);
        List<Senha> senhas = new ArrayList<>();
        senhas.add(senhaService.createSenha(utente));
        return senhas;
    }

    @GetMapping(path = "/senhas/{id}")
    @PreAuthorize("hasRole('ROLE_UTENTE')")
    public List<Senha> getSenha(@PathVariable String id) throws Exception {
        List<Senha> senhas = new ArrayList<>();
        if (senhaService.getSenhaById(Long.valueOf(id)).isPresent()){
            senhas.add(senhaService.getSenhaById(Long.valueOf(id)).get());
        }
        return senhas;
    }

    @GetMapping(path = "/calendariogeralutente/{especialidade}/{dia}/one")
    @PreAuthorize("hasAnyRole('ROLE_UTENTE', 'ROLE_MEDICO', 'ROLE_EMPLOYEE')")
    public List<Vaga> getOneVaga(@PathVariable("especialidade") String especialidade, @PathVariable("dia") String dia) {
        List<Vaga> vaga = new ArrayList<>();
        vaga.add(vagaService.getOneVaga(especialidade, dia));
        return vaga;
    }


    @PostMapping(path = "/calendariogeralutente", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @PreAuthorize("hasRole('ROLE_UTENTE')")
    public RedirectView getEspecialidade(EspecialidadeRequest request){
        return new RedirectView("/utente/calendariogeralutente/"+request.getEspecialidade());
    }

    @GetMapping(path = "/calendarutente/{dia}")
    @PreAuthorize("hasRole('ROLE_UTENTE')")
    public List<Appointment> getAppoinments(@PathVariable("dia") String dia) throws Exception {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Utente utente = utenteService.getLogged(auth);
        return consultasService.getAppointmentsUtenteByDate(utente,dia);
    }

    @GetMapping(value = "/lista-utentes")
    public String showUtentes(ModelMap map) {
        map.put("utenteList", utenteManagementController.getAllUtentes());
        return "/medico/lista-utentes";
    }

}
