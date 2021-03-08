package com.Bgrupo4.hospitalupskill.user.utente.controllers;

import com.Bgrupo4.hospitalupskill.services.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/utente")
@RequiredArgsConstructor
public class UtenteController {

    private final FileService fileService;

    @GetMapping(value = "/profileutente")
    public String showProfile(){
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
