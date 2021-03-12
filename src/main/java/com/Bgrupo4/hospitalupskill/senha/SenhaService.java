package com.Bgrupo4.hospitalupskill.senha;

import com.Bgrupo4.hospitalupskill.consultas.appointment.Appointment;
import com.Bgrupo4.hospitalupskill.consultas.appointment.AppointmentRepository;
import com.Bgrupo4.hospitalupskill.user.doctor.Doctor;
import com.Bgrupo4.hospitalupskill.user.doctor.DoctorRepository;
import com.Bgrupo4.hospitalupskill.user.utente.Utente;
import com.Bgrupo4.hospitalupskill.user.utente.UtenteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.print.Doc;
import java.time.LocalTime;
import java.util.*;

@Service
@RequiredArgsConstructor
public class SenhaService {

    private final SenhaRepository senhaRepository;
    private final DoctorRepository doctorRepository;
    private final UtenteRepository utenteRepository;
    private final AppointmentRepository appointmentRepository;

    public Senha createSenha(SenhaRequest request) {
        Optional<Appointment> appointmentOptional = appointmentRepository.findById(Long.valueOf(request.getAppointment()));
        if (appointmentOptional.isEmpty()) {
            throw new EntityNotFoundException(String.format("Appointment %s não foi encontrado", request.getAppointment()));
        }
        Appointment appointment = appointmentOptional.get();
        Optional<Doctor> doctorOptional = doctorRepository.findByUsername(appointment.getDoctor().getUsername());
        Optional<Utente> utenteOptional = utenteRepository.findByUsername(appointment.getUtente().getUsername());
        if (doctorOptional.isEmpty() || utenteOptional.isEmpty()) {
            throw new EntityNotFoundException(String.format("Doctor %s, utente %s não foi encontrado", appointment.getDoctor().getUsername(),
                    appointment.getUtente().getUsername()));
        }
        Senha senha = new Senha();
        senha.setDoctor(doctorOptional.get());
        senha.setUtente(utenteOptional.get());
        senha.setAppointment(appointmentOptional.get());
        senha.setDate(Calendar.getInstance().getTime());
        senha.setTime(String.valueOf(LocalTime.now()));
        senha.setNumeroSenha(getSenha(SenhaCategoria.REGISTAR_PRESENCA.name()));
        return senhaRepository.save(senha);
    }

    public Senha createSenha(Doctor doctor, Utente utente, Appointment appointment, SenhaCategoria senhaCategoria) {
        Optional<Doctor> doctorOptional = doctorRepository.findByUsername(doctor.getUsername());
        Optional<Utente> utenteOptional = utenteRepository.findByUsername(utente.getUsername());
        Optional<Appointment> appointmentOptional = appointmentRepository.findById(appointment.getId());
        if (doctorOptional.isEmpty() || utenteOptional.isEmpty() || appointmentOptional.isEmpty()) {
            throw new EntityNotFoundException(String.format("Doctor %s, utente %s ou appointment %s não foi encontrado", doctor.getUsername(),
                    utente.getUsername(), appointment.getId()));
        }
        Senha senha = new Senha();
        senha.setDoctor(doctorOptional.get());
        senha.setUtente(utenteOptional.get());
        senha.setAppointment(appointmentOptional.get());
        senha.setDate(Calendar.getInstance().getTime());
        senha.setTime(String.valueOf(LocalTime.now()));
        senha.setNumeroSenha(getSenha(senhaCategoria.name()));
        return senhaRepository.save(senha);
    }

    private String getSenha(String categoria) {
        switch (categoria) { //INFORMACAO, REGISTAR_PRESENCA
            case "INFORMACAO":
                return "A" + Senha.contadorA++;
            case "REGISTAR_PRESENCA":
                return "B" + Senha.contaborB++;
            default:
                return "C" + Senha.contadorC++;

        }
    }

    public List<String> getCategorias() {
        List<String> categorias = new ArrayList<>();
        for(SenhaCategoria categoria : SenhaCategoria.values()) {
            categorias.add(categoria.name());
        }
        return categorias;
    }

    public Optional<Senha> getSenhaById(Long id) {
        return senhaRepository.findById(id);
    }
}
