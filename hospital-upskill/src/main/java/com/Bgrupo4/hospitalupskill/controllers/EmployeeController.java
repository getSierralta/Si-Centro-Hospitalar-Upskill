package com.Bgrupo4.hospitalupskill.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeeController {

    @GetMapping(value = "/client-appointment")
    public String showClientAppointment(){
        return "client-appointment";
    }
}
