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

    @GetMapping(value = "/contacts")
    public String showContacts(){ return "contacts"; }

    @GetMapping(value = "/files-history")
    public String showFiles(ModelMap map){
        map.put("fileList", fileService.getFiles());
        return "files-history";
    }

}
