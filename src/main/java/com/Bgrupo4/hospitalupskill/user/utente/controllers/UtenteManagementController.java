package com.Bgrupo4.hospitalupskill.user.utente.controllers;

import com.Bgrupo4.hospitalupskill.consultas.ConsultasService;
import com.Bgrupo4.hospitalupskill.consultas.appointment.Appointment;
import com.Bgrupo4.hospitalupskill.consultas.receitas.Receita;
import com.Bgrupo4.hospitalupskill.consultas.receitas.ReceitaRequest;
import com.Bgrupo4.hospitalupskill.consultas.relatorio.Relatorio;
import com.Bgrupo4.hospitalupskill.consultas.relatorio.RelatorioRequest;
import com.Bgrupo4.hospitalupskill.user.SearchRequest;
import com.Bgrupo4.hospitalupskill.user.doctor.Doctor;
import com.Bgrupo4.hospitalupskill.user.doctor.DoctorService;
import com.Bgrupo4.hospitalupskill.user.utente.Utente;
import com.Bgrupo4.hospitalupskill.user.utente.UtenteService;
import com.Bgrupo4.hospitalupskill.user.utente.UtenteUpdateRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/utentes")
@AllArgsConstructor
public class UtenteManagementController {

    private final UtenteService utenteService;
    private final DoctorService doctorService;
    private final ConsultasService consultasService;

    @GetMapping(path = "{id}")
    @PreAuthorize("hasAuthority('utente:read')")
    public Optional<Utente> getUser(@PathVariable("id") Long id) {
        return utenteService.getUserById(id);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('utente:read')")
    public List<Utente> getAllUtentes() {
        return utenteService.getAllUtentes();
    }

    @PostMapping("/username/{role}")
    @PreAuthorize("hasAuthority('utente:read')")
    public RedirectView searchUsername(SearchRequest request, @PathVariable String role) {
        switch (role){
            case "colaborador":
                return new RedirectView("/employee/show-all-utentes/username/"+request.getUser());
            case "admin":
                return new RedirectView("/admin/lista-utentes/username/"+request.getUser());
            default:
                return new RedirectView("/400");
        }
    }

    @PostMapping("/nif/{role}")
    @PreAuthorize("hasAuthority('utente:read')")
    public RedirectView searchId(SearchRequest request, @PathVariable String role) {
        switch (role){
            case "colaborador":
                return new RedirectView("/employee/show-all-utentes/nif/"+request.getUser());
            case "admin":
                return new RedirectView("/admin/lista-utentes/nif/"+request.getUser());
            default:
                return new RedirectView("/400");
        }
    }
    @PostMapping("/{id}")
    @PreAuthorize("hasAuthority('utente:write')")
    public ResponseEntity<Utente> updateUtente(UtenteUpdateRequest request, @PathVariable Long id) {
        return ResponseEntity.ok(utenteService.updateUtente(id, request));
    }
    @PostMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('utente:write')")
    public ResponseEntity<Boolean> apagarUtente(@PathVariable Long id) {
        return ResponseEntity.ok(utenteService.deleteUtente(id));
    }

    @PostMapping("/fecharconsulta/{id}")
    @PreAuthorize("hasAuthority('utente:write')")
    public ResponseEntity<Appointment> fecharconsulta(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(consultasService.fecharConsulta(id));
    }

    @PostMapping("/marcarausencia/{id}")
    @PreAuthorize("hasAuthority('utente:write')")
    public ResponseEntity<Appointment> marcarAusencia(@PathVariable Long id) {
        return ResponseEntity.ok(consultasService.marcarAusencia(id));
    }

    @PostMapping("/relatorio/{id}")
    @PreAuthorize("hasAuthority('utente:write')")
    public ResponseEntity<Relatorio> writeRelatorio(RelatorioRequest request, @PathVariable Long id) throws Exception {
        Optional<Utente> utenteOptional = utenteService.getUserById(id);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Doctor doctor = doctorService.getLogged(auth);
        if (!utenteOptional.isPresent()){
            throw new EntityNotFoundException("utente não existe: "+id);
        }
        return ResponseEntity.ok(consultasService.createRelatorio(doctor, utenteOptional.get(), request));
    }

    @PostMapping("/receita/{id}")
    @PreAuthorize("hasAuthority('utente:write')")
    public ResponseEntity<Receita> writeReceita(ReceitaRequest request, @PathVariable Long id) throws Exception {
        Optional<Utente> utenteOptional = utenteService.getUserById(id);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Doctor doctor = doctorService.getLogged(auth);
        if (!utenteOptional.isPresent()){
            throw new EntityNotFoundException("utente não existe: "+id);
        }
        return ResponseEntity.ok(consultasService.createReceita(doctor, utenteOptional.get(), request));
    }


}