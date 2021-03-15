package com.Bgrupo4.hospitalupskill.user.doctor.controllers;

import com.Bgrupo4.hospitalupskill.Calendario.CalendarioService;
import com.Bgrupo4.hospitalupskill.user.doctor.Doctor;
import com.Bgrupo4.hospitalupskill.user.doctor.DoctorService;
import com.Bgrupo4.hospitalupskill.user.utente.Utente;
import com.Bgrupo4.hospitalupskill.user.utente.controllers.UtenteManagementController;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
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
    private final CalendarioService calendarioService;

    @GetMapping(value = "/profilemedico")
    public String showProfile(ModelMap map) throws Exception {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Doctor doctor = doctorService.getLogged(auth);
        map.put("medico", doctor);
        return "/medico/profilemedico";
    }

    @GetMapping(value = "/formularioCalendario")
    @PreAuthorize("hasRole('ROLE_MEDICO')")
    public String showFormularioCalendario(ModelMap map){
        map.put("especialidades", calendarioService.getEspecialidades());
        return "medico/formularioCalendario";
    }

    @GetMapping(value = "/calendariomedico/{especialidade}")
    @PreAuthorize("hasRole('ROLE_MEDICO')")
    public String showCalendarioGeral(@PathVariable String especialidade){
        return "medico/calendariomedico";
    }


    @GetMapping(value = "/calendariomedico/{especialidade}/error")
    @PreAuthorize("hasRole('ROLE_MEDICO')")
    public String showCalendarioGeralError(@PathVariable String especialidade){
        return "medico/calendariomedico";
    }

    @GetMapping(value = "/lista-utentes")
    public String showUtentes(ModelMap map) {
        map.put("utenteList", utenteManagementController.getAllUtentes());
        return "/medico/lista-utentes";
    }
}