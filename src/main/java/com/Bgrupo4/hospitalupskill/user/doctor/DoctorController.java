package com.Bgrupo4.hospitalupskill.user.doctor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping(path = "{id}")
    @PreAuthorize("hasAuthority('medico:read')")
    public Optional<Doctor> getUser(@PathVariable("id") Long id){
        return doctorService.getUserById(id);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('medico:read')")
    public List<Doctor> getAllDoctors() {
        return doctorService.getAllDoctors();
    }

    @DeleteMapping(path = "{id}")
    @PreAuthorize("hasAuthority('medico:write')")
    public void deleteDoctor(@PathVariable("id") Long id){
        doctorService.deleteDoctor(id);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('medico:write')")
    public void registerNewDoctor(@Validated @RequestBody Doctor doctor) {
        doctorService.registerDoctor(doctor);
    }

    @PutMapping(path = "{morada}")
    @PreAuthorize("hasAuthority('medico:write')")
    public void updateDoctorMorada(@PathVariable("morada") Long id, @RequestBody String morada) {
        doctorService.updateDoctorMorada(id, morada);
    }

    @PutMapping(path = "{localidade}")
    @PreAuthorize("hasAuthority('medico:write')")
    public void updateDoctorLocalidade(@PathVariable("localidade") Long id, @RequestBody String localidade) {
        doctorService.updateDoctorMorada(id, localidade);
    }

    @PutMapping(path = "{phone}")
    @PreAuthorize("hasAuthority('medico:write')")
    public void updateDoctorPhone(@PathVariable("phone") Long id, @RequestBody String phone) {
        doctorService.updateDoctorMorada(id, phone);
    }
}
