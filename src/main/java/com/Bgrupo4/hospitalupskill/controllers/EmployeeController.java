package com.Bgrupo4.hospitalupskill.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeeController {




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


}
