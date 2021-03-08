package com.Bgrupo4.hospitalupskill.user.utente;

import com.Bgrupo4.hospitalupskill.user.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/*@RestController
@RequestMapping("/api/utentes")
public class UtenteManagementController {


    private static final List<Utente> UTENTES = Arrays.asList(
    // somos utentes, felizes e doentes
            new Utente(123456789, "Rebeca Rebola", "reboca", "reboca@email.com","123",  "987654321"),
            new Utente(123456788, "Pepe Pepetola", "petola", "petola@email.com","123",  "Almada")
    );

    @GetMapping
    @PreAuthorize("hasAuthority('utente:read')")
    public List<Utente> getAllUtentes() {
        // this is a placeholder
        System.out.println("getAllUtentes");
        return UTENTES;
    }

    //todo: put that it takes json
    @PostMapping
    @PreAuthorize("hasAuthority('utente:write')")
    public void registerNewUtente(@RequestBody Utente utente) {
        // this is also a placeholder
        System.out.println("registerNewUtente");
        System.out.println(utente);
    }

    @DeleteMapping(path = "{id}")
    @PreAuthorize("hasAuthority('utente:write')")
    public void deleteUtente(@PathVariable("id") Integer id){
        // same sh*t, different method
        System.out.println("deleteUtente");
        System.out.println(id);
    }

    @PutMapping(path = "{id}")
    @PreAuthorize("hasAuthority('utente:write')")
    public void updateUtente(@PathVariable("id") Integer id, @RequestBody Utente utente) {
        // same as the above
        System.out.println("updateUtente");
        System.out.printf("%s %s%n", id, utente);
    }
}

 */
