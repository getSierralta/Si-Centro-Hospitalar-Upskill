package com.Bgrupo4.hospitalupskill.user.employee.doctor;

import com.Bgrupo4.hospitalupskill.user.FakeApplicationUserDaoService;
import com.Bgrupo4.hospitalupskill.user.UserRole;
import com.Bgrupo4.hospitalupskill.user.employee.Employee;
import com.Bgrupo4.hospitalupskill.user.employee.EmployeeRole;
import com.Bgrupo4.hospitalupskill.user.employee.Hospital;
import com.Bgrupo4.hospitalupskill.user.utente.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("management/users/medicos")
public class DoctorManagementController {

    @Autowired
    private FakeApplicationUserDaoService fakeApplicationUserDaoService;

    // FOR TESTING PURPOSES ONLY
    private static Hospital upskill() {
        return new Hospital(121, "Upskill", "upskill@upskill.upskill", "Avenida Up n. Skill",
                "Sintra", "456456665", "UpPhoto");
    }

    private static final List<Doctor> MEDICOS = Arrays.asList(
    // computer says no
            new Doctor(144456789, "Dr Love", "luv", "luv@email.com",
                    "123", "Rua B n1", "Alameda", "981154325", new Date(25/05/1989),
                    UserRole.MEDICO, 005, upskill(), "Cedula1", EmployeeRole.DOCTOR, EmployeeRole.DOCTOR,
                    Especialidade.Geral, Especialidade.Cardiologia, Especialidade.Fisioteratia, Especialidade.Ginecologia,
                    Especialidade.Radiologia),
            new Doctor(145645563, "Dr Jones", "bones", "bones@email.com",
                    "123", "Rua E n2", "Alameda", "981244322", new Date(25/05/1989),
                    UserRole.MEDICO, 005, upskill(), "Cedula2", EmployeeRole.DOCTOR, EmployeeRole.DOCTOR,
                    Especialidade.Geral, Especialidade.Cardiologia, Especialidade.Fisioteratia, Especialidade.Ginecologia,
                    Especialidade.Radiologia)
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
}
