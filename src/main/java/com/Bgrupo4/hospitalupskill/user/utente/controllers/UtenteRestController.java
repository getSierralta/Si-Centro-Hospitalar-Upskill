package com.Bgrupo4.hospitalupskill.user.utente.controllers;


import com.Bgrupo4.hospitalupskill.consultas.Calendario.EspecialidadeRequest;
import com.Bgrupo4.hospitalupskill.consultas.senha.Senha;
import com.Bgrupo4.hospitalupskill.consultas.senha.SenhaService;
import com.Bgrupo4.hospitalupskill.consultas.vaga.Vaga;
import com.Bgrupo4.hospitalupskill.consultas.vaga.VagaService;
import com.Bgrupo4.hospitalupskill.user.registration.RegistrationService;
import com.Bgrupo4.hospitalupskill.user.utente.Utente;
import com.Bgrupo4.hospitalupskill.user.utente.UtenteRegistrationRequest;
import com.Bgrupo4.hospitalupskill.user.utente.UtenteService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/utente")
@RequiredArgsConstructor
public class UtenteRestController {

    @Autowired
    private UtenteService utenteService;
    private final RegistrationService registrationService;
    private final VagaService vagaService;
    private final SenhaService senhaService;

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
    @PreAuthorize("hasRole('ROLE_UTENTE')")
    public List<Vaga> getVagas(@PathVariable("especialidade") String especialidade, @PathVariable("dia") String dia) {
        return vagaService.getVagas(especialidade, dia);
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

    @GetMapping(path = "/calendariogeralutente/{especialidade}/{dia}/one")
    @PreAuthorize("hasRole('ROLE_UTENTE')")
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

}
