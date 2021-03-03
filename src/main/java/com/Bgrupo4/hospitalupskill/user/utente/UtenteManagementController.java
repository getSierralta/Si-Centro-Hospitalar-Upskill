package com.Bgrupo4.hospitalupskill.user.utente;

import com.Bgrupo4.hospitalupskill.user.FakeApplicationUserDaoService;
import com.Bgrupo4.hospitalupskill.user.UserRole;
import com.Bgrupo4.hospitalupskill.user.employee.doctor.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("management/users/utentes")
public class UtenteManagementController {

    @Autowired
    private FakeApplicationUserDaoService fakeApplicationUserDaoService;

    private static final List<Utente> UTENTES = Arrays.asList(
    // somos utentes, felizes e doentes
            new Utente(123456789, "Rebeca Rebola", "reboca", "reboca@email.com",
                    "123", "Rua A n1", "Almada", "987654321", new Date(25/05/1989),
                    UserRole.UTENTE, 001, "Multicare"),
            new Utente(123456788, "Pepe Pepetola", "petola", "petola@email.com",
                    "123", "Rua B n1", "Almada", "987654322", new Date(25/05/1989),
                    UserRole.UTENTE, 002, "Multicare")
    );

    @GetMapping
    @PreAuthorize("hasAuthority('utente:read')")
    public List<Utente> getAllUtentes() {
        // this is a placeholder
        System.out.println("getAllUtentes");
        return UTENTES;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('utente:write')")
    public void registerNewUtente(@RequestBody Utente utente) {
        // this is also a placeholder
        System.out.println("registerNewUtente");
        System.out.println(utente);
    }

    @DeleteMapping(path = "{utente}")
    @PreAuthorize("hasAuthority('utente:write')")
    public void deleteUtente(@PathVariable("utente") Integer nif){
        // same sh*t, different method
        System.out.println("deleteUtente");
        System.out.println(nif);
    }

    @PutMapping(path = "{utente}")
    @PreAuthorize("hasAuthority('utente:write')")
    public void updateUtente(@PathVariable("utente") Integer nif, @RequestBody Utente utente) {
        // same as the above
        System.out.println("updateUtente");
        System.out.printf("%s %s%n", nif, utente);
    }
}
