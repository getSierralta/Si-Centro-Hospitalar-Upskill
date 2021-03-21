package com.Bgrupo4.hospitalupskill.user.utente.controllers;

import com.Bgrupo4.hospitalupskill.calendario.CalendarioService;
import com.Bgrupo4.hospitalupskill.consultas.ConsultasService;
import com.Bgrupo4.hospitalupskill.consultas.appointment.Appointment;
import com.Bgrupo4.hospitalupskill.consultas.appointment.FakeAppointment;
import com.Bgrupo4.hospitalupskill.invoices.InvoiceController;
import com.Bgrupo4.hospitalupskill.invoices.InvoiceService;
import com.Bgrupo4.hospitalupskill.consultas.receitas.Receita;
import com.Bgrupo4.hospitalupskill.consultas.relatorio.Relatorio;
import com.Bgrupo4.hospitalupskill.senha.SenhaService;
import com.Bgrupo4.hospitalupskill.user.utente.Utente;
import com.Bgrupo4.hospitalupskill.user.utente.UtenteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;

import java.util.List;

import static com.Bgrupo4.hospitalupskill.HospitalUpskillApplication.ECRA;

@Controller
@RequiredArgsConstructor
@RequestMapping(path = "utente")
public class UtenteController {


    private final UtenteService utenteService;
    private final CalendarioService calendarioService;
    private final SenhaService senhaService;
    private final InvoiceService invoiceService;
    private final ConsultasService consultasService;


    @GetMapping(value = "/profileutente")
    @PreAuthorize("hasRole('ROLE_UTENTE')")
    public String showProfile(ModelMap map) throws Exception {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Utente utente = utenteService.getLogged(auth);
        map.put("utente", utente);
        try {
            map.put("consulta",utenteService.getNextAppointment(utente));
        }catch (EntityNotFoundException e){
            map.put("consulta", new FakeAppointment());
        }
        try {
            map.put("receita",utenteService.getLastReceita(utente));
        }catch (EntityNotFoundException e){
            map.put("receita", new FakeAppointment());
        }
        return "utente/profileutente";
    }

    @GetMapping(value = "/tracknumberutente")
    @PreAuthorize("hasRole('ROLE_UTENTE')")
    public String showTrackNumber(ModelMap map) throws Exception {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Utente utente = utenteService.getLogged(auth);
        System.out.println(senhaService.getSenhasByUtente(utente));
        map.put("senhas", senhaService.getSenhasByUtente(utente));
        map.put("ecra", ECRA);
        return "utente/tracknumberutente";
    }

    @GetMapping(value = "/settings")
    @PreAuthorize("hasRole('ROLE_UTENTE')")
    public String showSetting(ModelMap map) throws Exception {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Utente utente = utenteService.getLogged(auth);
        map.put("utente", utente);
        return "utente/settings";
    }


    @GetMapping(value = "/formularioCalendario")
    @PreAuthorize("hasRole('ROLE_UTENTE')")
    public String showFormularioCalendario(ModelMap map){
        map.put("especialidades", calendarioService.getEspecialidades());
        return "utente/formularioCalendario";
    }

    @GetMapping(value = "/calendariogeralutente/{especialidade}")
    @PreAuthorize("hasRole('ROLE_UTENTE')")
    public String showCalendarioGeral(@PathVariable String especialidade){
        return "utente/calendariogeralutente";
    }


    @GetMapping(value = "/calendariogeralutente/{especialidade}/error")
    @PreAuthorize("hasRole('ROLE_UTENTE')")
    public String showCalendarioGeralError(@PathVariable String especialidade){
        return "utente/calendariogeralutente";
    }


    @GetMapping(value = "/bills")
    @PreAuthorize("hasRole('ROLE_UTENTE')")
    public String showBills(){
        return "utente/bills";
    }


    @GetMapping(value = "/calendarutente")
    @PreAuthorize("hasRole('ROLE_UTENTE')")
    public String showCalendarioPessoal(){
        return "utente/calendarutente";
    }

    @GetMapping(value = "/receitas/{id}")
    @PreAuthorize("hasAuthority('utente:read')")
    public ResponseEntity<List<Receita>> getReceita(@PathVariable("id") String id) {
        return ResponseEntity.ok(utenteService.getReceitasByUtente(Long.valueOf(id)));
    }

    @GetMapping(value = "/relatorios/{id}")
    @PreAuthorize("hasAuthority('utente:read')")
    public ResponseEntity<List<Relatorio>> getRelatorios(@PathVariable("id") String id) {
        return ResponseEntity.ok(utenteService.getRelatorioByUtente(Long.valueOf(id)));
    }

    @GetMapping(value = "/consultas/{id}")
    @PreAuthorize("hasAuthority('utente:read')")
    public ResponseEntity<List<Appointment>> getConsultas(@PathVariable("id") String id) {
        return ResponseEntity.ok(consultasService.getAppointmentsUtente(Long.valueOf(id)));
    }



    @GetMapping(value = "/payments")
    @PreAuthorize("hasRole('ROLE_UTENTE')")
    public String showBills(ModelMap map, @RequestParam (required = false) String search, @RequestParam (required = false) String status) throws Exception {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Utente utente = utenteService.getLogged(auth);
        String nif = utente.getNif();
        map.put("invoiceList", invoiceService.getMyList(nif, search, status));
        return "/utente/payments";
    }
}
