package com.Bgrupo4.hospitalupskill.user.utente.controllers;

import com.Bgrupo4.hospitalupskill.consultas.appointment.FakeAppointment;
import com.Bgrupo4.hospitalupskill.services.FileService;
import com.Bgrupo4.hospitalupskill.user.utente.Utente;
import com.Bgrupo4.hospitalupskill.user.utente.UtenteService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Controller
@RequestMapping("/utente")
@RequiredArgsConstructor
public class UtenteController {

    private final FileService fileService;
    private final UtenteService utenteService;


    @GetMapping(value = "/profileutente")
    public String showProfile(ModelMap map) throws Exception {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Utente utente = utenteService.getLogged(auth);
        map.put("utente", utente);
        try {
            map.put("consulta",utenteService.getNextAppointment(utente));
        }catch (EntityNotFoundException e){
            map.put("consulta", new FakeAppointment());
        }
        return "/utente/profileutente";
    }

    @GetMapping(value = "/checkinutente")
    public String showCheckIn(){
        return "/utente/check-in-utente";
    }

    @GetMapping(value = "/tracknumberutente")
    public String showTrackNumber(){
        return "/utente/tracknumberutente";
    }

    @GetMapping(value = "/getnumber")
    public String showGetNumber(){
        return "/utente/getnumber";
    }

    @GetMapping(value = "/billsutente")
    public String showBills(){
        return "/utente/bills";
    }

    @GetMapping(value = "/filesutente")
    public String showFiles(ModelMap map){
        map.put("fileList", fileService.getFiles());
        return "/utente/files";
    }

    @GetMapping(value = "/contactsutente")
    public String showContacts(){
        return "/utente/contactsutente";
    }

    @GetMapping(value = "/settings")
    public String showSettings(){
        return "/utente/settings";
    }

    @GetMapping(value = "/calendariogeralutente")
    public String showCalendar(){
        return "/utente/calendariogeralutente";
    }

    @GetMapping(value = "/calendarutente")
    public String showEvents(){
        return "/utente/calendar";
    }
}
