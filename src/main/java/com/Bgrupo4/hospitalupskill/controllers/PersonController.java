package com.Bgrupo4.hospitalupskill.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PersonController {

    // Landing Page

    @GetMapping(value = "/")
    public String showIndex(){
        return "/pessoa/index";
    }

    @GetMapping(value = "/login")
    public String showLogIn(){
        return "/pessoa/log-in";
    }

    @GetMapping(value = "/registration")
    public String showRegistration(){
        return "/pessoa/register";
    }


    @GetMapping(value = "/about-us")
    public String showAboutUs(){
        return "/pessoa/about-us";
    }

    @GetMapping(value = "/services")
    public String showServices(){
        return "/pessoa/services";
    }

    @GetMapping(value = "/contacts")
    public String showContacts(){ return "/pessoa/contacts"; }

    //Messages

    @GetMapping(value = "/error")
    public String showError(){
        return "error";
    }

    @GetMapping(value = "/info")
    public String showInfo(){
        return "/pessoa/info";
    }

    @GetMapping(value = "/success")
    public String showSuccess(){
        return "/pessoa/success";
    }

}
