package com.Bgrupo4.hospitalupskill.user.employee;

import com.Bgrupo4.hospitalupskill.user.FakeApplicationUserDaoService;
import com.Bgrupo4.hospitalupskill.user.UserRole;
import com.Bgrupo4.hospitalupskill.user.employee.doctor.Doctor;
import com.Bgrupo4.hospitalupskill.user.utente.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("management/users/colaboradores")
public class EmployeeManagementController {

    @Autowired
    private FakeApplicationUserDaoService fakeApplicationUserDaoService;

    // FOR TESTING PURPOSES ONLY
    private static Hospital upskill() {
        return new Hospital(121, "Upskill", "upskill@upskill.upskill", "Avenida Up n. Skill",
                "Sintra", "456456665", "UpPhoto");
    }

    private static final List<Employee> COLABORADORES = Arrays.asList(
    // underpaid staff list goes here
            new Employee(123456789, "Shoshonka Petrokova", "petronka", "petronka@email.com",
                    "123", "Rua C n2", "Alameda", "987654325", new Date(25/05/1989),
                    UserRole.COLABORADOR, 001, upskill(), EmployeeRole.STAFF, EmployeeRole.STAFF),
            new Employee(123456228, "Reese Withoutherspoon", "respoon", "respoon@email.com",
                    "123", "Rua A n5", "Almada", "987644322", new Date(25/05/1989),
                    UserRole.COLABORADOR, 002, upskill(), EmployeeRole.STAFF, EmployeeRole.STAFF)
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
}
