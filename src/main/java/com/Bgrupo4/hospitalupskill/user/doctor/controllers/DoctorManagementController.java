package com.Bgrupo4.hospitalupskill.user.doctor.controllers;

import com.Bgrupo4.hospitalupskill.calendario.EspecialidadeRequest;
import com.Bgrupo4.hospitalupskill.consultas.ConsultasService;
import com.Bgrupo4.hospitalupskill.consultas.Status;
import com.Bgrupo4.hospitalupskill.consultas.appointment.Appointment;
import com.Bgrupo4.hospitalupskill.user.doctor.Doctor;
import com.Bgrupo4.hospitalupskill.user.doctor.DoctorRequest;
import com.Bgrupo4.hospitalupskill.user.doctor.DoctorService;
import com.Bgrupo4.hospitalupskill.user.doctor.DoctorUpdateRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/doctors")
@AllArgsConstructor
public class DoctorManagementController {

    private DoctorService doctorService;
    private ConsultasService consultasService;

    @GetMapping(path = "{id}")
    @PreAuthorize("hasAuthority('medico:read')")
    public Optional<Doctor> getUser(@PathVariable("id") Long id) {
        return doctorService.getUserById(id);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('medico:read')")
    public List<Doctor> getAllDoctors() {
        return doctorService.getAllDoctors();
    }

    @DeleteMapping(path = "{id}")
    @PreAuthorize("hasAuthority('medico:write')")
    public void deleteDoctor(@PathVariable("id") Long id) {
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

    @PostMapping(path = "/calendariomedico", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @PreAuthorize("hasRole('ROLE_MEDICO') or hasRole('ROLE_MEDICO_RESPONSAVEL')")
    public RedirectView getEspecialidade(EspecialidadeRequest request){
        return new RedirectView("/medico/calendariomedico/"+request.getEspecialidade());
    }

    @PostMapping(path = "/update", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @PreAuthorize("hasRole('ROLE_MEDICO') or hasRole('ROLE_MEDICO_RESPONSAVEL')")
    public RedirectView update(DoctorUpdateRequest request) throws Exception {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Doctor doctor = doctorService.getLogged(auth);
        doctorService.updateDoctor(doctor, request);
        return new RedirectView("/medico/settings");
    }

    @PostMapping(path = "/uploadImage")
    @PreAuthorize("hasRole('ROLE_MEDICO') or hasRole('ROLE_MEDICO_RESPONSAVEL')")
    public RedirectView updateImage(@RequestParam("imageFile") MultipartFile imageFile) throws Exception {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Doctor doctor = doctorService.getLogged(auth);
        try {
            doctorService.updateDoctor(doctor, imageFile);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("-------------- eror saving photo");
            return new RedirectView("/500");
        }
        return new RedirectView("/medico/settings");
    }

    @GetMapping(path = "/calendarmedico/{dia}")
    @PreAuthorize("hasRole('ROLE_MEDICO') or hasRole('ROLE_MEDICO_RESPONSAVEL')")
    public List<Appointment> getAppoinments(@PathVariable("dia") String dia) throws Exception {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Doctor doctor = doctorService.getLogged(auth);
        List<Appointment> appointments = new ArrayList<>();
        for (Appointment appointment: consultasService.getAppointmentsMedicoByDate(doctor,dia)) {
            if (appointment.getStatus() == Status.OPEN || appointment.getStatus() == Status.LATE ){
                appointments.add(appointment);
            }
        }
        return appointments;
    }
}