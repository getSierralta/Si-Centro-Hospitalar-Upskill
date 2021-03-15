package com.Bgrupo4.hospitalupskill.user.utente.controllers;

import com.Bgrupo4.hospitalupskill.Calendario.CalendarioService;
import com.Bgrupo4.hospitalupskill.consultas.appointment.FakeAppointment;
import com.Bgrupo4.hospitalupskill.senha.SenhaService;
import com.Bgrupo4.hospitalupskill.user.utente.Utente;
import com.Bgrupo4.hospitalupskill.user.utente.UtenteService;
import com.Bgrupo4.hospitalupskill.user.utente.UtenteUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.persistence.EntityNotFoundException;

import static com.Bgrupo4.hospitalupskill.HospitalUpskillApplication.ECRA;

@Controller
@RequiredArgsConstructor
@RequestMapping(path = "utente")
public class UtenteController {


    private final UtenteService utenteService;
    private final CalendarioService calendarioService;
    private final SenhaService senhaService;


    @GetMapping(value = "/profileutente")
    @PreAuthorize("hasRole('ROLE_UTENTE')")
    public String showProfile(ModelMap map) throws Exception {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Utente utente = utenteService.getLogged(auth);
        map.put("utente", utente);
        try {
            map.put("consulta",utenteService.getNextAppointment(utente));
        }catch (EntityNotFoundException e){
            map.put("consulta", new FakeAppointment());
        }
        try {
            map.put("receita",utenteService.getLastReceita(utente));
        }catch (EntityNotFoundException e){
            map.put("receita", new FakeAppointment());
        }
        return "utente/profileutente";
    }

    @GetMapping(value = "/tracknumberutente")
    @PreAuthorize("hasRole('ROLE_UTENTE')")
    public String showTrackNumber(ModelMap map) throws Exception {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Utente utente = utenteService.getLogged(auth);
        System.out.println(senhaService.getSenhasByUtente(utente));
        map.put("senhas", senhaService.getSenhasByUtente(utente));
        map.put("ecra", ECRA);
        return "utente/tracknumberutente";
    }

    @GetMapping(value = "/settings")
    @PreAuthorize("hasRole('ROLE_UTENTE')")
    public String showSetting(ModelMap map) throws Exception {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Utente utente = utenteService.getLogged(auth);
        map.put("utente", utente);
        return "utente/settings";
    }


    @GetMapping(value = "/formularioCalendario")
    @PreAuthorize("hasRole('ROLE_UTENTE')")
    public String showFormularioCalendario(ModelMap map){
        map.put("especialidades", calendarioService.getEspecialidades());
        return "utente/formularioCalendario";
    }

    @GetMapping(value = "/calendariogeralutente/{especialidade}")
    @PreAuthorize("hasRole('ROLE_UTENTE')")
    public String showCalendarioGeral(@PathVariable String especialidade){
        return "utente/calendariogeralutente";
    }


    @GetMapping(value = "/calendariogeralutente/{especialidade}/error")
    @PreAuthorize("hasRole('ROLE_UTENTE')")
    public String showCalendarioGeralError(@PathVariable String especialidade){
        return "utente/calendariogeralutente";
    }


    @GetMapping(value = "/bills")
    @PreAuthorize("hasRole('ROLE_UTENTE')")
    public String showBills(){
        return "utente/bills";
    }

    /*
    @GetMapping(value = "/formularioCalendario")
    @PreAuthorize("hasRole('ROLE_UTENTE')")
    public String showCalendarioPessoal(){
        return "utente/formularioCalendario";
    }*/




}
