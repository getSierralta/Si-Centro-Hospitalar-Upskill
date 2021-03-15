package com.Bgrupo4.hospitalupskill.user.employee.controllers;

import com.Bgrupo4.hospitalupskill.Calendario.EspecialidadeRequest;
import com.Bgrupo4.hospitalupskill.user.employee.Employee;
import com.Bgrupo4.hospitalupskill.user.employee.EmployeeRequest;
import com.Bgrupo4.hospitalupskill.user.employee.EmployeeService;
import com.Bgrupo4.hospitalupskill.user.utente.Utente;
import com.Bgrupo4.hospitalupskill.user.utente.UtenteRequest;
import com.Bgrupo4.hospitalupskill.user.utente.UtenteService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employee")
@AllArgsConstructor
public class EmployeeRestController {

    @Autowired
    private final EmployeeService employeeService;


    @GetMapping(path = "/find-employee/{id}")
    @PreAuthorize("hasAuthority('colaborador:read')")
    public Optional<Employee> getEmployee(@PathVariable("id") Long id){
        return employeeService.getEmployeeById(id);
    }

    @GetMapping(path = "/find-employee/all")
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

    @PutMapping("/update-employee/{id}")
    @PreAuthorize("hasAuthority('colaborador:write')")
    public ResponseEntity<Employee> updateEmployee(@RequestBody EmployeeRequest request, @PathVariable Long id) {
        return ResponseEntity.ok(employeeService.updateEmployee(id, request));
    }

    @PostMapping(path = "/calendario", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @PreAuthorize("hasRole('ROLE_COLABORADOR')")
    public RedirectView getEspecialidade(EspecialidadeRequest request){
        return new RedirectView("/employee/calendarioemployee/"+request.getEspecialidade());
    }
}
