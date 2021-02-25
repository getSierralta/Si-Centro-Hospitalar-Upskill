package com.Bgrupo4.hospitalupskill.controllers;

import com.Bgrupo4.hospitalupskill.services.CalendarService;
import com.Bgrupo4.hospitalupskill.services.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PersonController {

    // Landing Page

    @GetMapping(value = "/")
    public String showIndex(){
        return "/pessoa/index";
    }

    @GetMapping(value = "/log-in")
    public String showLogIn(){
        return "/pessoa/log-in";
    }

    @GetMapping(value = "/register")
    public String showRegister(){
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

    //geral

    @GetMapping(value = "/geralCalendar")
    public String showCalendar(){
        return "/pessoa/geralCalendar";
    }

    @GetMapping(value = "/settings")
    public String showSettings(){
        return "settings";
    }

    @GetMapping(value = "/profile")
    public String showProfile(){return "profile";}

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
