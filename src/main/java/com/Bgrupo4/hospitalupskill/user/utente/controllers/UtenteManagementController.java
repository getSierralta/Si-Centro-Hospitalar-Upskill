package com.Bgrupo4.hospitalupskill.user.utente.controllers;

import com.Bgrupo4.hospitalupskill.user.utente.Utente;
import com.Bgrupo4.hospitalupskill.user.utente.UtenteRequest;
import com.Bgrupo4.hospitalupskill.user.utente.UtenteService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/utentes")
@AllArgsConstructor
public class UtenteManagementController {

    @Autowired
    private final UtenteService utenteService;

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

    /*
    @PostMapping("/{id}")
    @PreAuthorize("hasAuthority('utente:write')")
    public ResponseEntity<Utente> updateUtente(@RequestBody UtenteRequest request, @PathVariable Long id) {
        return ResponseEntity.ok(utenteService.updateUtente(id, request));
    }
*/

}