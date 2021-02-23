package com.Bgrupo4.hospitalupskill.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClientController {

    @GetMapping(value = "/payments")
    public String showPayments(){
        return "payments";
    }

    @GetMapping(value = "/getnumber")
    public String showGetNumber(){
        return "getnumber";
    }

    @GetMapping(value = "/services")
    public String showServices(){
        return "services";
    }

    @GetMapping(value = "/contacts")
    public String showContacts(){ return "contacts"; }
}
