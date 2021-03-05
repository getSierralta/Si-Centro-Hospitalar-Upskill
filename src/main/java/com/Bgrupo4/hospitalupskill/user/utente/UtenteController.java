package com.Bgrupo4.hospitalupskill.user.utente;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("api/utentes")
public class UtenteController {

    @Autowired
    private UtenteService utenteService;

    @GetMapping(path = "{id}")
    public Optional<Utente> getUser(@PathVariable("id") Long id){
        return utenteService.getUserById(id);
    }
}
