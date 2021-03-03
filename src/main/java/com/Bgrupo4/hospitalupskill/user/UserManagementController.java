package com.Bgrupo4.hospitalupskill.user;

import com.Bgrupo4.hospitalupskill.user.employee.Employee;
import com.Bgrupo4.hospitalupskill.user.employee.doctor.Doctor;
import com.Bgrupo4.hospitalupskill.user.utente.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("management/users")
public class UserManagementController {

    @Autowired
    private FakeApplicationUserDaoService fakeApplicationUserDaoService;

    //////////////////// UTENTE

    /*
    private static final List<Utente> UTENTES = Arrays.asList(
    // somos utentes, felizes e doentes
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

    //////////////////// MEDICO


    private static final List<Doctor> MEDICOS = Arrays.asList(
    // we are rich because we are doctors and doctors make a lot of money
    );

    @GetMapping
    @PreAuthorize("hasAuthority('medico:read')")
    public List<Doctor> getAllMedicos() {
        System.out.println("getAllMedicos");
        return MEDICOS;
    }


    @PostMapping
    @PreAuthorize("hasAuthority('medico:write')")
    public void registerNewMedico(@RequestBody Doctor doctor) {
        System.out.println("registerNewMedico");
        System.out.println(doctor);
    }

    @DeleteMapping(path = "{medico}")
    @PreAuthorize("hasAuthority('medico:write')")
    public void deleteMedico(@PathVariable("medico") Integer nif){
        System.out.println("deleteMedico");
        System.out.println(nif);
    }

    @PutMapping(path = "{medico}")
    @PreAuthorize("hasAuthority('medico:write')")
    public void updateMedico(@PathVariable("medico") Integer nif, @RequestBody Doctor doctor) {
        System.out.println("updateDoctor");
        System.out.printf("%s %s%n", nif, doctor);
    }

    //////////////////// COLABORADOR

    private static final List<Employee> COLABORADORES = Arrays.asList(
    // underpaid staff list goes here
    );

    @GetMapping
    @PreAuthorize("hasAuthority('colaborador:read')")
    public List<Employee> getAllColaboradores() {
        System.out.println("getAllColaboradores");
        return COLABORADORES;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('colaborador:write')")
    public void registerNewColaborador(@RequestBody Employee employee) {
        System.out.println("registerNewColaborador");
        System.out.println(employee);
    }

    @DeleteMapping(path = "{colaborador}")
    @PreAuthorize("hasAuthority('colaborador:write')")
    public void deleteColaborador(@PathVariable("colaborador") Integer nif){
        System.out.println("deleteColaborador");
        System.out.println(nif);
    }

    @PutMapping(path = "{colaborador}")
    @PreAuthorize("hasAuthority('colaborador:write')")
    public void updateDoctor(@PathVariable("colaborador") Integer nif, @RequestBody Employee employee) {
        System.out.println("updateDoctor");
        System.out.printf("%s %s%n", nif, employee);
    }

    //////////////////// RESPONSAVEL

    // @GetMapping > @PreAuthorize("hasAuthority('responsavel:read')")
    // @PostMapping > @PreAuthorize("hasAuthority('responsavel:write')")
    // @DeleteMapping > @PreAuthorize("hasAuthority('responsavel:write')")
    // @PutMapping > @PreAuthorize("hasAuthority('responsavel:write')")
    */
}
