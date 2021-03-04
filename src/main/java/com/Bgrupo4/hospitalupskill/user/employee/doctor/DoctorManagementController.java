package com.Bgrupo4.hospitalupskill.user.employee.doctor;

import com.Bgrupo4.hospitalupskill.user.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

import static com.Bgrupo4.hospitalupskill.HospitalUpskillApplication.especialidades;
import static com.Bgrupo4.hospitalupskill.HospitalUpskillApplication.upskill;


@RestController
@RequestMapping("management/users/doctors")
public class DoctorManagementController {

    private List<Doctor> MEDICOS = Arrays.asList(
            // computer says no
            new Doctor(144456789, "Dr Love", "luv", "luv@email.com",
                    "123", UserRole.MEDICO.name(), upskill, "aasfghkjg", especialidades),
            new Doctor(145645563, "Dr Jones", "bones", "bones@email.com",
                    "123", UserRole.MEDICO_RESPONSAVEL.name(), upskill, "cedula2", especialidades)
    );


    @GetMapping
    @PreAuthorize("hasAuthority('medico:read')")
    public List<Doctor> getAllMedicos() {
        System.out.println("getAllMedicos");
        return null;
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
}
