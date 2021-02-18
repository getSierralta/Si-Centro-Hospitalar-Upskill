package com.Bgrupo4.hospitalupskill.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PersonController {

    @GetMapping(value = "/log-in")
    public String showLogIn(){
        return "log-in";
    }

    @GetMapping(value = "/profile")
    public String showProfile(){
        return "profile";
    }

    @GetMapping(value = "/about-us")
    public String showAboutUs(){
        return "about-us";
    }

    @GetMapping(value = "/check-in")
    public String showCheckIn(){
        return "check-in";
    }

    @GetMapping(value = "/settings")
    public String showSettings(){
        return "settings";
    }

    @GetMapping(value = "/services")
    public String showServices(){
        return "services";
    }
}
