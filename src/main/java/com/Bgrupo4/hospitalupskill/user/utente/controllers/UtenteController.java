package com.Bgrupo4.hospitalupskill.user.utente.controllers;

import com.Bgrupo4.hospitalupskill.Calendario.CalendarioService;
import com.Bgrupo4.hospitalupskill.consultas.appointment.FakeAppointment;
import com.Bgrupo4.hospitalupskill.services.FileService;
import com.Bgrupo4.hospitalupskill.user.utente.Utente;
import com.Bgrupo4.hospitalupskill.user.utente.UtenteService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.EntityNotFoundException;

@Controller
@RequiredArgsConstructor
@RequestMapping(path = "utente")
public class UtenteController {

    private final FileService fileService;
    private final UtenteService utenteService;
    private final CalendarioService calendarioService;


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



    @GetMapping(value = "/checkinutente")
    @PreAuthorize("hasRole('ROLE_UTENTE')")
    public String showCheckIn(){
        return "utente/check-in-utente";
    }

    @GetMapping(value = "/tracknumberutente")
    @PreAuthorize("hasRole('ROLE_UTENTE')")
    public String showTrackNumber(){
        return "utente/tracknumberutente";
    }

    @GetMapping(value = "/getnumber")
    @PreAuthorize("hasRole('ROLE_UTENTE')")
    public String showGetNumber(){
        return "utente/getnumber";
    }

    @GetMapping(value = "/bills")
    @PreAuthorize("hasRole('ROLE_UTENTE')")
    public String showBills(){
        return "utente/bills";
    }

    @GetMapping(value = "/files")
    @PreAuthorize("hasRole('ROLE_UTENTE')")
    public String showFiles(ModelMap map){
        map.put("fileList", fileService.getFiles());
        return "utente/files";
    }

    @GetMapping(value = "/contactsutente")
    @PreAuthorize("hasRole('ROLE_UTENTE')")
    public String showContacts(){
        return "utente/contactsutente";
    }

    @GetMapping(value = "/settings")
    @PreAuthorize("hasRole('ROLE_UTENTE')")
    public String showSettings(){
        return "utente/settings";
    }




}
