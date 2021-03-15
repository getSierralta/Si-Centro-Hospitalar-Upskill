package com.Bgrupo4.hospitalupskill.user.doctor.controllers;

import com.Bgrupo4.hospitalupskill.user.doctor.Doctor;
import com.Bgrupo4.hospitalupskill.user.doctor.DoctorService;
import com.Bgrupo4.hospitalupskill.user.utente.Utente;
import com.Bgrupo4.hospitalupskill.user.utente.controllers.UtenteManagementController;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/medico")
@RequiredArgsConstructor
public class DoctorController {

    private final UtenteManagementController utenteManagementController;
    private final DoctorService doctorService;

    @GetMapping(value = "/profilemedico")
    public String showProfile(ModelMap map) throws Exception {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Doctor doctor = doctorService.getLogged(auth);
        map.put("medico", doctor);
        return "/medico/profilemedico";
    }

    @GetMapping(value = "/lista-utentes")
    public String showUtentes(ModelMap map) {
        map.put("utenteList", utenteManagementController.getAllUtentes());
        return "/medico/lista-utentes";
    }
}