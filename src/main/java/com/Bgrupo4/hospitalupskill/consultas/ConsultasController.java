package com.Bgrupo4.hospitalupskill.consultas;


import com.Bgrupo4.hospitalupskill.consultas.appointment.Appointment;
import com.Bgrupo4.hospitalupskill.consultas.appointment.AppointmentCreationRequest;
import com.Bgrupo4.hospitalupskill.consultas.relatorio.Relatorio;
import com.Bgrupo4.hospitalupskill.consultas.relatorio.RelatorioRequest;
import com.Bgrupo4.hospitalupskill.consultas.vaga.Vaga;
import com.Bgrupo4.hospitalupskill.consultas.vaga.VagaCreationRequest;
import com.Bgrupo4.hospitalupskill.consultas.vaga.VagaService;
import com.Bgrupo4.hospitalupskill.senha.Senha;
import com.Bgrupo4.hospitalupskill.senha.SenhaService;
import com.Bgrupo4.hospitalupskill.user.doctor.Doctor;
import com.Bgrupo4.hospitalupskill.user.doctor.DoctorService;
import com.Bgrupo4.hospitalupskill.user.utente.Utente;
import com.Bgrupo4.hospitalupskill.user.utente.UtenteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/consultas")
public class ConsultasController {

    private final ConsultasService consultasService;
    private final UtenteService utenteService;
    private final SenhaService senhaService;
    private final DoctorService doctorService;

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

    @PostMapping("/appointments/utente/{id}")
    public ResponseEntity<Appointment> createAppointmentUtente(@PathVariable Long id) throws Exception {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Utente utente = utenteService.getLogged(auth);
        return ResponseEntity.ok(consultasService.createAppointment(id, utente));
    }

    @PostMapping("/appointments/{utente}/{id}")
    public ResponseEntity<Appointment> createAppointmentEmployee(@PathVariable Long id, @PathVariable Long utente) throws Exception {
        Optional<Utente> utente2 = utenteService.getUserById(utente);
        if (utente2.isPresent()){
            return ResponseEntity.ok(consultasService.createAppointment(id, utente2.get()));
        }
        throw new EntityNotFoundException("Usuario não encontrado");
    }


    @PostMapping("/appointments")
    public ResponseEntity<Appointment> createAppointment (@RequestBody AppointmentCreationRequest request) {
        return ResponseEntity.ok(consultasService.createAppointment(request));
    }



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

    @GetMapping("/senha/{id}")
    public ResponseEntity<Senha> getSenha(@PathVariable String id) {
        if (senhaService.getSenhaById(Long.valueOf(id)).isEmpty()){
            throw new EntityNotFoundException("Senha não existe: "+id);
        }
        return ResponseEntity.ok(senhaService.getSenhaById(Long.valueOf(id)).get());
    }
    @PostMapping("/senha/{id}")
    public ResponseEntity<Appointment> startConsulta(@PathVariable String id) {
        Optional<Senha> senhaOptional = senhaService.getSenhaById(Long.valueOf(id));
        if (senhaOptional.isEmpty()){
            throw new EntityNotFoundException("Senha não existe: "+id);
        }
        return ResponseEntity.ok(consultasService.startConsulta(senhaOptional.get()));
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
