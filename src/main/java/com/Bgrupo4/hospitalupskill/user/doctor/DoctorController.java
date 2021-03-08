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

    @PutMapping(path = "{id}")
    @PreAuthorize("hasAuthority('medico:write')")
    public void updateDoctor(@PathVariable("id") Long id, @RequestBody DoctorRequest request) {
        doctorService.updateDoctor(id, request);
    }
}