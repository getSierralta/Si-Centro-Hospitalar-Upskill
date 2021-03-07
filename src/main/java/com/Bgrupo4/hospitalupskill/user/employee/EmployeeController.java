package com.Bgrupo4.hospitalupskill.user.employee;

import com.Bgrupo4.hospitalupskill.user.UserRole;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

import static com.Bgrupo4.hospitalupskill.HospitalUpskillApplication.upskill;

@RestController
@RequestMapping("/api/employee")
@AllArgsConstructor
public class EmployeeController {

    private static final List<Employee> COLABORADORES = Arrays.asList(
            // underpaid staff list goes here
            new Employee(123456789, "Shoshonka Petrokova", "petronka", "petronka@email.com",
                    "123", UserRole.COLABORADOR.name(),  upskill),
            new Employee(123456789, "Juan", "juan", "juan@email.com",
                    "123", UserRole.COLABORADOR.name(),  upskill),
            new Employee(123456228, "Reese Withoutherspoon", "respoon", "respoon@email.com",
                    "123", UserRole.COLABORADOR_RESPONSAVEL.name(),  upskill)
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

    @DeleteMapping(path = "{id}")
    @PreAuthorize("hasAuthority('colaborador:write')")
    public void deleteColaborador(@PathVariable("id") Integer id){
        System.out.println("deleteColaborador");
        System.out.println(id);
    }

    @PutMapping(path = "{id}")
    @PreAuthorize("hasAuthority('colaborador:write')")
    public void updateDoctor(@PathVariable("id") Integer id, @RequestBody Employee employee) {
        System.out.println("updateDoctor");
        System.out.printf("%s %s%n", id, employee);
    }
}
