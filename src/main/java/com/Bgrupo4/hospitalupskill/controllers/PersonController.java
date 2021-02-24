package com.Bgrupo4.hospitalupskill.controllers;

import com.Bgrupo4.hospitalupskill.services.CalendarService;
import com.Bgrupo4.hospitalupskill.services.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PersonController {

    @Autowired
    FileService fileService;

    @GetMapping(value = "/")
    public String showIndex(){
        return "index";
    }

    @Autowired
    CalendarService calendarService;

    @GetMapping(value = "/log-in")
    public String showLogIn(){
        return "log-in";
    }

    @GetMapping(value = "/register")
    public String showRegister(){
        return "register";
    }

    @GetMapping(value = "/profile")
    public String showProfile(){
        return "profile";
    }

    @GetMapping(value = "/about-us")
    public String showAboutUs(){
        return "about-us";
    }


    @GetMapping(value = "/settings")
    public String showSettings(){
        return "settings";
    }

    @GetMapping(value = "/bills")
    public String showBills(){
        return "bills";
    }


    @GetMapping(value = "/gearlCalendar")
    public String showCalendar(){
        return "geralCalendar";
    }

    @GetMapping(value = "/error")
    public String showError(){
        return "error";
    }

    @GetMapping(value = "/info")
    public String showInfo(){
        return "info";
    }

    @GetMapping(value = "/success")
    public String showSuccess(){
        return "success";
    }

    @GetMapping(value = "/files-history")
    public String showFiles(ModelMap map){
        map.put("fileList", fileService.getFiles());
        return "files-history";
    }

    @GetMapping(value = "/personal-calendar")
    public String showEvents(ModelMap map){
        map.put("calendarList", calendarService.getMarcacoes());
        return "calendar";
    }

}
