package com.Bgrupo4.hospitalupskill.user;

import com.Bgrupo4.hospitalupskill.user.utente.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class ApplicationUserManagementController {

    @Autowired
    private final ApplicationUserService applicationUserService;

    public ApplicationUserManagementController(ApplicationUserService applicationUserService) {
        this.applicationUserService = applicationUserService;
    }

    @GetMapping
    @PreAuthorize("hasAuthority('utente:read')")
    public List<ApplicationUser> getUsers() {
        // this is a placeholder
        System.out.println("get Users");
        return applicationUserService.getUsers();
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
