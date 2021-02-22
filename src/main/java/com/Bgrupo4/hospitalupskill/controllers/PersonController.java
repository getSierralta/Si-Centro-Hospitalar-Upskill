package com.Bgrupo4.hospitalupskill.controllers;

import com.Bgrupo4.hospitalupskill.services.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PersonController {

    @Autowired
    FileService fileService;

    //todo max
    @GetMapping(value = "/")
    public String showIndex(){
        return "index";
    }

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


    //todo max
    @GetMapping(value = "/bills")
    public String showBills(){
        return "bills";
    }

    //todo max
    @GetMapping(value = "/calendar")
    public String showCalendar(){
        return "calendar";
    }

    //todo max
    @GetMapping(value = "/error")
    public String showError(){
        return "error";
    }

    //todo max
    @GetMapping(value = "/info")
    public String showSuccess(){
        return "info";
    }



    @GetMapping(value = "/files-history")
    public String showFiles(ModelMap map){
        map.put("fileList", fileService.getFiles());
        return "files-history";
    }

}
