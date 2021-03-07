package com.Bgrupo4.hospitalupskill.user.employee;

import com.Bgrupo4.hospitalupskill.user.UserRole;
import com.Bgrupo4.hospitalupskill.user.doctor.Doctor;
import com.Bgrupo4.hospitalupskill.user.doctor.DoctorRequest;
import com.Bgrupo4.hospitalupskill.user.doctor.DoctorService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static com.Bgrupo4.hospitalupskill.HospitalUpskillApplication.upskill;

@RestController
@RequestMapping("/api/employee")
@AllArgsConstructor
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

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
}
