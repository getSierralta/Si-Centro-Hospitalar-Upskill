package com.Bgrupo4.hospitalupskill.user.employee;

import com.Bgrupo4.hospitalupskill.user.utente.Utente;
import com.Bgrupo4.hospitalupskill.user.utente.UtenteRequest;
import com.Bgrupo4.hospitalupskill.user.utente.UtenteService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employee")
@AllArgsConstructor
public class EmployeeRestController {

    @Autowired
    private EmployeeService employeeService;

    private final UtenteService utenteService;

    @GetMapping(path = "{id}")
    @PreAuthorize("hasAuthority('colaborador:read')")
    public Optional<Employee> getUser(@PathVariable("id") Long id){
        return employeeService.getUserById(id);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('colaborador:read')")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @DeleteMapping(path = "{id}")
    @PreAuthorize("hasAuthority('colaborador:write')")
    public void deleteEmployee(@PathVariable("id") Long id){
        employeeService.deleteEmployee(id);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('colaborador:write')")
    public void registerNewEmployee(@Validated @RequestBody Employee employee) {
        employeeService.registerEmployee(employee);
    }

    @PutMapping(path = "{id}")
    @PreAuthorize("hasAuthority('colaborador:write')")
    public void updateEmployee(@PathVariable("id") Long id, @RequestBody EmployeeRequest request) {
        employeeService.updateEmployee(id, request);
    }

    /* UTENTE */
    // UTENTE MANAGEMENT

    //TODO rever
    @GetMapping(path = "/find-utente/all")
    public List<Utente> getAllUtentes() {
        return utenteService.getAllUtentes();
    }

    @GetMapping(path = "/find-utente/{id}")
    public Optional<Utente> getUtenteById(@PathVariable("id") Long id) {
        return utenteService.getUserById(id);
    }

    @PostMapping("/update-utente/{id}")
    //@PreAuthorize
    public ResponseEntity<Utente> updateUtente(@RequestBody UtenteRequest request, @PathVariable Long id) {
        return ResponseEntity.ok(utenteService.updateUtente(id, request));
    }
}
