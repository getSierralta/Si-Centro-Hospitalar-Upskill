package com.Bgrupo4.hospitalupskill.user.doctor.controllers;

import com.Bgrupo4.hospitalupskill.calendario.CalendarioService;
import com.Bgrupo4.hospitalupskill.consultas.ConsultasService;
import com.Bgrupo4.hospitalupskill.senha.Senha;
import com.Bgrupo4.hospitalupskill.senha.SenhaService;
import com.Bgrupo4.hospitalupskill.user.doctor.Doctor;
import com.Bgrupo4.hospitalupskill.user.doctor.DoctorService;
import com.Bgrupo4.hospitalupskill.user.utente.UtenteService;
import com.Bgrupo4.hospitalupskill.user.utente.controllers.UtenteManagementController;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/medico")
@RequiredArgsConstructor
public class DoctorController {

    private final DoctorService doctorService;
    private final CalendarioService calendarioService;
    private final SenhaService senhaService;
    private final ConsultasService consultasService;
    private final UtenteService utenteService;


    @GetMapping(value = "/profilemedico")
    public String showProfile(ModelMap map) throws Exception {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Doctor doctor = doctorService.getLogged(auth);
        map.put("medico", doctor);
        return "/medico/profilemedico";
    }

    @GetMapping(value = "/formularioCalendario")
    @PreAuthorize("hasRole('ROLE_MEDICO') or hasRole('ROLE_MEDICO_RESPONSAVEL')")
    public String showFormularioCalendario(ModelMap map) throws Exception{
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Doctor doctor = doctorService.getLogged(auth);
        map.put("medico", doctor);
        map.put("especialidades", calendarioService.getEspecialidades());
        return "medico/formularioCalendario";
    }

    @GetMapping(value = "/calendariomedico/{especialidade}")
    @PreAuthorize("hasRole('ROLE_MEDICO') or hasRole('ROLE_MEDICO_RESPONSAVEL')")
    public String showCalendarioGeral(@PathVariable String especialidade, ModelMap map) throws Exception{
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Doctor doctor = doctorService.getLogged(auth);
        map.put("medico", doctor);
        return "medico/calendariomedico";
    }


    @GetMapping(value = "/lista-utentes")
    @PreAuthorize("hasRole('ROLE_MEDICO') or hasRole('ROLE_MEDICO_RESPONSAVEL')")
    public String showUtentes(ModelMap map) throws Exception{
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Doctor doctor = doctorService.getLogged(auth);
        map.put("medico", doctor);
        map.put("utenteList", utenteService.getAllUtentes());
        return "/medico/lista-utentes";
    }

    @GetMapping(value = "/lista-medicos")
    @PreAuthorize("hasRole('ROLE_MEDICO_RESPONSAVEL')")
    public String showMedicos(ModelMap map) throws Exception {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Doctor doctor = doctorService.getLogged(auth);
        map.put("medico", doctor);
        map.put("doctorList", doctorService.getAllDoctors());
        return "/medico/lista-medicos";
    }

    @GetMapping(value = "/salaDeEspera")
    @PreAuthorize("hasRole('ROLE_MEDICO') or hasRole('ROLE_MEDICO_RESPONSAVEL')")
    public String showSalaDeEspera(ModelMap map) throws Exception {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Doctor doctor = doctorService.getLogged(auth);
        List<Senha> senhas = new ArrayList<>();
        senhas.addAll(consultasService.getSenhasOnGoingAppoinmentByMedico(doctor));
        senhas.addAll(consultasService.getSenhasLateAppoinmentByMedico(doctor));
        senhas.addAll(senhaService.getSenhasByMedico(doctor));
        map.put("utenteList", senhas);
        map.put("medico", doctor);
        return "/medico/salaDeEspera";
    }

    @GetMapping(value = "/ongoing/{id}")
    @PreAuthorize("hasRole('ROLE_MEDICO') or hasRole('ROLE_MEDICO_RESPONSAVEL')")
    public String showOnGoing(ModelMap map, @PathVariable String id) throws Exception {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Doctor doctor = doctorService.getLogged(auth);
        map.put("medico", doctor);

        if(senhaService.getSenhaById(Long.valueOf(id)).isEmpty()){
            throw new EntityNotFoundException("Senha não existe: "+id);
        }
        Senha senha = senhaService.getSenhaById(Long.valueOf(id)).get();
        if (utenteService.getUserById(senha.getUtente().getId()).isEmpty()){
            throw new EntityNotFoundException("Utente não existe: "+senha.getUtente().getId());
        }
        map.put("utente", utenteService.getUserById(senha.getUtente().getId()).get());
        return "/medico/ongoing";
    }

    @GetMapping(value = "/ongoing")
    @PreAuthorize("hasRole('ROLE_MEDICO') or hasRole('ROLE_MEDICO_RESPONSAVEL')")
    public String showOnGoing(ModelMap map) throws Exception {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Doctor doctor = doctorService.getLogged(auth);
        List<Senha> senha = consultasService.getSenhasOnGoingAppoinmentByMedico(doctor);
        if (senha.isEmpty()){

        }else{
            if (utenteService.getUserById(senha.get(0).getUtente().getId()).isEmpty()){
                throw new EntityNotFoundException("Utente não existe: "+senha.get(0).getUtente().getId());
            }
            map.put("utente", utenteService.getUserById(senha.get(0).getUtente().getId()).get());
        }
        return "/medico/ongoing";
    }

    @GetMapping(value = "/calendarmedico")
    @PreAuthorize("hasRole('ROLE_MEDICO') or hasRole('ROLE_MEDICO_RESPONSAVEL')")
    public String showCalendarioPessoal(ModelMap map) throws Exception{
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Doctor doctor = doctorService.getLogged(auth);
        map.put("medico", doctor);
        return "medico/calendarmedico";
    }

    @GetMapping(value = "/settings")
    @PreAuthorize("hasRole('ROLE_MEDICO') or hasRole('ROLE_MEDICO_RESPONSAVEL')")
    public String showSetting(ModelMap map) throws Exception {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Doctor doctor = doctorService.getLogged(auth);
        map.put("medico", doctor);
        System.out.println(doctor.getUserRole().toString());
        return "medico/settings";
    }

}