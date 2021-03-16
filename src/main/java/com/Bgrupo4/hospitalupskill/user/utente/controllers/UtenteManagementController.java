package com.Bgrupo4.hospitalupskill.user.utente.controllers;

import com.Bgrupo4.hospitalupskill.consultas.ConsultasService;
import com.Bgrupo4.hospitalupskill.consultas.relatorio.Relatorio;
import com.Bgrupo4.hospitalupskill.consultas.relatorio.RelatorioRequest;
import com.Bgrupo4.hospitalupskill.user.doctor.Doctor;
import com.Bgrupo4.hospitalupskill.user.doctor.DoctorService;
import com.Bgrupo4.hospitalupskill.user.utente.Utente;
import com.Bgrupo4.hospitalupskill.user.utente.UtenteRequest;
import com.Bgrupo4.hospitalupskill.user.utente.UtenteService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

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


    @PostMapping("/{id}")
    @PreAuthorize("hasAuthority('utente:write')")
    public ResponseEntity<Utente> updateUtente(UtenteRequest request, @PathVariable Long id) {
        return ResponseEntity.ok(utenteService.updateUtente(id, request));
    }

    @PostMapping("/relatorio/{id}")
    @PreAuthorize("hasAuthority('utente:write')")
    public ResponseEntity<Relatorio> writeRelatorio(RelatorioRequest request, @PathVariable Long id) throws Exception {
        Optional<Utente> utenteOptional = utenteService.getUserById(Long.valueOf(id));
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Doctor doctor = doctorService.getLogged(auth);
        if (utenteOptional.isEmpty()){
            throw new EntityNotFoundException("utente não existe: "+id);
        }
        return ResponseEntity.ok(consultasService.createRelatorio(doctor, utenteOptional.get(), request));
    }


}