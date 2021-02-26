package com.Bgrupo4.hospitalupskill.controllers;

import com.Bgrupo4.hospitalupskill.services.CalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClientController {

    @Autowired
    CalendarService calendarService;

    @GetMapping(value = "/profileutente")
    public String showProfile(){
        return "/utente/profileutente";
    }

    @GetMapping(value = "/checkinutente")
    public String showCheckIn(){
        return "/utente/check-in-utente";
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
    public String showFiles(){
        return "/utente/files";
    }


    @GetMapping(value = "/calendarutente")
    public String showEvents(ModelMap map){
        map.put("calendarList", calendarService.getMarcacoes());
        return "/utente/calendar";
    }
}
