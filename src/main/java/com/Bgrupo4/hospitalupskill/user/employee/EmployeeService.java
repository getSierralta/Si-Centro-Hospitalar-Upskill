package com.Bgrupo4.hospitalupskill.user.employee;

import com.Bgrupo4.hospitalupskill.user.ApplicationUserService;
import com.Bgrupo4.hospitalupskill.user.doctor.Doctor;
import com.Bgrupo4.hospitalupskill.user.doctor.DoctorRequest;
import com.Bgrupo4.hospitalupskill.user.utente.Utente;
import com.Bgrupo4.hospitalupskill.user.utente.UtenteRequest;
import com.Bgrupo4.hospitalupskill.user.utente.UtenteService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeService {
    private final static String USER_NOT_FOUND_MSG = "O colaborador %s não foi encontrado";

    private final EmployeeRepository employeeRepository;
    private final ApplicationUserService applicationUserService;
    private final UtenteService utenteService;

    public Optional<Employee> getUserById(Long id) {
        return employeeRepository.findById(id);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    public void registerEmployee(Employee employee) {
        applicationUserService.enableAndSave(employee);
    }

    public Employee updateEmployee(Long id, EmployeeRequest request) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (!employee.isPresent()) {
            throw new EntityNotFoundException(String.format("Colaborador %s não foi encontrado", id));
        }
        Employee employee1 = employee.get();
        employee1.setMorada(request.getMorada());
        return employeeRepository.save(employee1);
    }

    // EMPLOYEE
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

    public Optional<Employee> getUserByUsername(String username) {
        return employeeRepository.findByUsername(username);
    }

    public Employee getLogged(Authentication auth) throws Exception {
        String principal = auth.getPrincipal().toString();
        String[] split = principal.split("username='");
        String[] split2 = split[1].split("',");
        Optional<Employee> employee = getUserByUsername(split2[0]);
        if (employee.isEmpty()){
            throw new Exception("There's no logged person");
        }
        return employee.get();
    }
}
