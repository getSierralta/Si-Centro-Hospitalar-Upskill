package com.Bgrupo4.hospitalupskill.user.utente.controllers;


import com.Bgrupo4.hospitalupskill.registration.RegistrationService;
import com.Bgrupo4.hospitalupskill.services.FileService;
import com.Bgrupo4.hospitalupskill.user.utente.Utente;
import com.Bgrupo4.hospitalupskill.user.utente.UtenteRegistrationRequest;
import com.Bgrupo4.hospitalupskill.user.utente.UtenteService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@RestController
@RequestMapping("/utente")
@RequiredArgsConstructor
public class UtenteRestController {

    @Autowired
    private UtenteService utenteService;
    private final RegistrationService registrationService;

    @GetMapping(path = "{id}")
    public Optional<Utente> getUser(@PathVariable("id") Long id){
        return utenteService.getUserById(id);
    }


    @PostMapping(path = "/register", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ModelAndView register( UtenteRegistrationRequest request){
        System.out.println("inside the register");
        utenteService.registerUtente(request);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/utente/register");
        return modelAndView;
    }

    @GetMapping(value = "/register")
    public String showConfirmEmail(){
        return "/utente/register";
    }


    @GetMapping(path = "/register/confirm")
    public String confirm(@RequestParam("token") String token) {
        return registrationService.confirmToken(token);
    }

}
