package com.Bgrupo4.hospitalupskill.consultas;


import com.Bgrupo4.hospitalupskill.consultas.appointment.Appointment;
import com.Bgrupo4.hospitalupskill.consultas.appointment.AppointmentCreationRequest;
import com.Bgrupo4.hospitalupskill.consultas.vaga.Vaga;
import com.Bgrupo4.hospitalupskill.consultas.vaga.VagaCreationRequest;
import com.Bgrupo4.hospitalupskill.consultas.vaga.VagaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/consultas")
@RequiredArgsConstructor
public class ConsultasController {

    //todo: authorization

    private final ConsultasService consultasService;

    @GetMapping("/appointments")
    public ResponseEntity getAppointments(@RequestParam(required = false) Long id) {
        if (id == null) {
            return ResponseEntity.ok(consultasService.getAppointments());
        }
        return ResponseEntity.ok(consultasService.getAppointment(id));
    }

    @GetMapping("/appointments/{id}")
    public ResponseEntity<Appointment> getAppointment (@PathVariable Long id) {
        return ResponseEntity.ok(consultasService.getAppointment(id));
    }

    @PostMapping("/appointments")
    public ResponseEntity<Appointment> createAppointment (@RequestBody AppointmentCreationRequest request) {
        return ResponseEntity.ok(consultasService.createAppointment(request));
    }

    @DeleteMapping("/appointments/{id}")
    public ResponseEntity<Vaga> cancelAppointment (@PathVariable Long id) {
        return ResponseEntity.ok(consultasService.cancelAppointment(id));
    }
/*
    @PatchMapping("/appointments/{id}")
    public ResponseEntity<Appointment> updateAppointment (@RequestBody AppointmentCreationRequest request, @PathVariable Long id) {
        return ResponseEntity.ok(consultasService.updateAppointment(id, request));
    }*/


    @GetMapping("/vagas")
    public ResponseEntity getVagas(@RequestParam(required = false) Long id) {
        if (id == null) {
            return ResponseEntity.ok(consultasService.getVagas());
        }
        return ResponseEntity.ok(consultasService.getVaga(id));
    }

    @GetMapping("/vagas/{id}")
    public ResponseEntity<Vaga> getVaga(@PathVariable Long id) {
        return ResponseEntity.ok(consultasService.getVaga(id));
    }
    @GetMapping("/vagas/doctors/{id}")
    public ResponseEntity<List<Vaga>> getVagaByDoctor(@PathVariable Long id) {
        return ResponseEntity.ok(consultasService.getVagas(id));
    }
    @GetMapping("/vagas/especialidades/{especialidade}")
    public ResponseEntity<List<Vaga>> getVagaByEspecialidade(@PathVariable String especialidade) {
        return ResponseEntity.ok(consultasService.getVagas(especialidade));
    }

    @PostMapping("/vagas")
    public ResponseEntity<Vaga> createVaga(@RequestBody VagaCreationRequest request) {
        return ResponseEntity.ok(consultasService.createVaga(request));
    }

    @DeleteMapping("/vaga/{id}")
    public ResponseEntity<Vaga> deleteVaga (@PathVariable Long id) {
        consultasService.deleteVaga(id);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/vaga/{id}")
    public ResponseEntity<Vaga> closeVaga (@PathVariable Long id) {
        return ResponseEntity.ok(consultasService.updateVaga(id, false));
    }
}
