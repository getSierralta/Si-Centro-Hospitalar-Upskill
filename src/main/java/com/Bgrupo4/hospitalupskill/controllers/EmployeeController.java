package com.Bgrupo4.hospitalupskill.controllers;

import com.Bgrupo4.hospitalupskill.services.CalendarService;
import com.Bgrupo4.hospitalupskill.services.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeeController {

    @Autowired
    FileService fileService;


    @GetMapping(value = "/check-in")
    public String showCheckIn(){
        return "/employee/check-in";
    }

    @GetMapping(value = "/client-appointment")
    public String showClientAppointment(){
        return "/employee/client-appointment";
    }

    @GetMapping(value = "/payments")
    public String showPayments(){
        return "/employee/payments";
    }

    //todo especificar utente
    @GetMapping(value = "/files-history")
    public String showFiles(ModelMap map){
        map.put("fileList", fileService.getFiles());
        return "/medico/files-history";
    }
}
