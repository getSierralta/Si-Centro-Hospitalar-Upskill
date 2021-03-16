package com.Bgrupo4.hospitalupskill.consultas;

import com.Bgrupo4.hospitalupskill.consultas.appointment.Appointment;
import com.Bgrupo4.hospitalupskill.consultas.appointment.AppointmentCreationRequest;
import com.Bgrupo4.hospitalupskill.consultas.appointment.AppointmentRepository;
import com.Bgrupo4.hospitalupskill.consultas.receitas.Receita;
import com.Bgrupo4.hospitalupskill.consultas.vaga.Vaga;
import com.Bgrupo4.hospitalupskill.consultas.vaga.VagaCreationRequest;
import com.Bgrupo4.hospitalupskill.consultas.vaga.VagaRepository;
import com.Bgrupo4.hospitalupskill.consultas.vaga.VagaService;
import com.Bgrupo4.hospitalupskill.senha.Senha;
import com.Bgrupo4.hospitalupskill.senha.SenhaRepository;
import com.Bgrupo4.hospitalupskill.senha.SenhaService;
import com.Bgrupo4.hospitalupskill.user.doctor.Doctor;
import com.Bgrupo4.hospitalupskill.user.doctor.DoctorRepository;
import com.Bgrupo4.hospitalupskill.user.utente.Utente;
import com.Bgrupo4.hospitalupskill.user.utente.UtenteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.print.Doc;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

@Service
@RequiredArgsConstructor
public class ConsultasService {

    private final AppointmentRepository appointmentRepository;
    private final VagaRepository vagaRepository;
    private final DoctorRepository doctorRepository;
    private final UtenteRepository utenteRepository;
    private final SenhaRepository senhaRepository;

    public List<Appointment> getAppointments() {
        return appointmentRepository.findAll();
    }

    public List<Appointment> getAppointmentsUtente(Long id) {
        return appointmentRepository.findAllByUtenteId(id);
    }

    public List<Vaga> getVagas() {
        return vagaRepository.findAll();
    }

    public List<Vaga> getVagas(Long id) {
        return vagaRepository.findAllByDoctorId(id);
    }

    public Vaga createVaga(Vaga vaga) {
        return vagaRepository.save(vaga);
    }

    public void deleteVaga(Long id) {
        vagaRepository.deleteById(id);
    }

    public List<Appointment> getAppointmentsUtenteOrderByDate(Utente utente) {
        return appointmentRepository.findAllByUtenteOrderByDateAsc(utente);
    }

    public List<Vaga> getVagas(String especialidade) {
        return appointmentRepository.findAllByEspecialidade(especialidade);
    }

    public Appointment getAppointment(Long id) {
        Optional<Appointment> appointment = appointmentRepository.findById(id);
        if (appointment.isPresent()) {
            return appointment.get();
        }
        throw new EntityNotFoundException(String.format("Cant' find appointment %s", id));
    }

    public Vaga getVaga(Long id) {
        Optional<Vaga> vaga = vagaRepository.findById(id);
        if (vaga.isPresent()) {
            return vaga.get();
        }
        throw new EntityNotFoundException(String.format("Cant' find vaga %s", id));
    }

    public Appointment createAppointment(AppointmentCreationRequest request) {
        //todo verificar se o appoinment ja existe(?)
        Optional<Doctor> doctor = doctorRepository.findById(request.getDoctor());
        Optional<Utente> utente = utenteRepository.findById(request.getUtente());
        Optional<Vaga> vaga = vagaRepository.findById(request.getVaga());
        if (!doctor.isPresent() || !utente.isPresent() || !vaga.isPresent()) {
            throw new EntityNotFoundException(String.format("Utente %s, vaga %s ou Medico %s não foi encontrado", request.getUtente(), request.getVaga(), request.getDoctor()));
        }
        Appointment appointment = new Appointment();
        vaga.ifPresent(vaga1 -> updateVaga(vaga1.getId(), false));
        BeanUtils.copyProperties(request, appointment);
        appointment.setDoctor(doctor.get());
        appointment.setUtente(utente.get());
        appointment.setDate(vaga.get().getDate());
        appointment.setTime(vaga.get().getTime());
        appointment.setEspecialidade(vaga.get().getEspecialidade());
        return appointmentRepository.save(appointment);
    }

    public Appointment createAppointment(Vaga vaga, Utente utente) {
        Optional<Doctor> doctor = doctorRepository.findById(vaga.getDoctor().getId());
        Optional<Utente> utenteOpt = utenteRepository.findById(utente.getId());
        Optional<Vaga> vagaOptional = vagaRepository.findById(vaga.getId());
        if (doctor.isEmpty() || utenteOpt.isEmpty() || vagaOptional.isEmpty()) {
            throw new EntityNotFoundException(String.format("Utente %s ou vaga %s não foi encontrado", utente.getUsername(), vaga.getId()));
        }
        Appointment appointment = new Appointment();
        vagaOptional.ifPresent(vaga1 -> updateVaga(vaga1.getId(), false));
        appointment.setDate(vagaOptional.get().getDate());
        appointment.setTime(vagaOptional.get().getTime());
        appointment.setEspecialidade(vagaOptional.get().getEspecialidade());
        appointment.setDoctor(doctor.get());
        appointment.setUtente(utenteOpt.get());
        return appointmentRepository.save(appointment);
    }

    public Appointment createAppointment(Long id, Utente utente) {
        Optional<Vaga> vagaOptional = vagaRepository.findById(id);
        if (vagaOptional.isEmpty()) {
            throw new EntityNotFoundException(String.format("Vaga %s não foi encontrada", id));
        }
        Vaga vaga = vagaOptional.get();
        if (vaga.isFree()) {
            Optional<Doctor> doctor = doctorRepository.findById(vaga.getDoctor().getId());
            if (doctor.isEmpty()) {
                throw new EntityNotFoundException(String.format("Medico %s não foi encontrada", vaga.getDoctor().getUsername()));
            }
            Appointment appointment = new Appointment();
            updateVaga(vaga.getId(), false);
            appointment.setDate(vaga.getDate());
            appointment.setTime(vaga.getTime());
            appointment.setEspecialidade(vaga.getEspecialidade());
            appointment.setDoctor(doctor.get());
            appointment.setUtente(utente);
            return appointmentRepository.save(appointment);
        }
        throw new IllegalArgumentException(String.format("A vaga %s ja foi prenchida", vaga.getId()));
    }

    public Appointment cancelAppointment(Long id) {
        Optional<Appointment> appointment = appointmentRepository.findById(id);
        if (appointment.isEmpty()) {
            throw new EntityNotFoundException(String.format("A marcação %s nao foi encontrada", id));
        }
        if (appointment.get().getStatus() == Status.OPEN){
            Vaga vaga = new Vaga();
            Appointment appointment1 = appointment.get();
            appointment1.setStatus(Status.CANCELLED);
            vaga.setDate(appointment1.getDate());
            vaga.setDoctor(appointment1.getDoctor());
            vaga.setEspecialidade(appointment1.getDoctor().getEspecialidade());
            vaga.setDate(appointment1.getDate());
            vaga.setTime(appointment1.getTime());
            vagaRepository.save(vaga);
            return appointmentRepository.save(appointment1);
        }
        throw new IllegalArgumentException("Cannot cancel an appointment in other state than OPEN");
    }


    public Vaga createVaga(VagaCreationRequest request) {
        Optional<Doctor> doctor = doctorRepository.findById(request.getDoctor());
        if (!doctor.isPresent()) {
            throw new EntityNotFoundException(String.format("Medico %s não foi encontrado", request.getDoctor()));
        }
        Vaga vaga = new Vaga();
        BeanUtils.copyProperties(request, vaga);
        vaga.setDoctor(doctor.get());
        return vagaRepository.save(vaga);
    }


    public Vaga updateVaga(Long id, Boolean free) {
        Optional<Vaga> vaga = vagaRepository.findById(id);
        if (vaga.isEmpty()) {
            throw new EntityNotFoundException(String.format("A vaga %s não existe", id));
        }
        Vaga vaga1 = vaga.get();
        vaga1.setFree(free);
        return vagaRepository.save(vaga1);
    }

    public List<Appointment> getAppointmentsUtenteByDate(Utente utente, String dia) {
        String[] split = dia.split("-");
        String[] m = split[1].split("");
        String[] d = split[2].split("");
        String month = m.length == 2 ? split[1] : "0" + split[1];
        String day = d.length == 2 ? split[2] : "0" + split[2];
        return appointmentRepository.findAllByUtenteAndDate(utente, new GregorianCalendar(Integer.parseInt(split[0]), Integer.parseInt(month), Integer.parseInt(day)));
    }

    public Appointment startConsulta(Senha senha) {
        Optional<Appointment> appointmentOptional = appointmentRepository.findById(senha.getAppointment().getId());
        if (appointmentOptional.isEmpty()){
            throw new EntityNotFoundException("Consulta não encontrada: "+senha.getAppointment().getId());
        }
        Appointment appointment = appointmentOptional.get();
        appointment.setStatus(Status.GOING);
        appointment.setStartedAt(String.valueOf(LocalTime.now()));
        senha.setFoiAtentido(true);
        senhaRepository.save(senha);
        return appointmentRepository.save(appointment);
    }
}

