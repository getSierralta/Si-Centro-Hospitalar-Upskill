package com.Bgrupo4.hospitalupskill.consultas;

import com.Bgrupo4.hospitalupskill.consultas.appointment.Appointment;
import com.Bgrupo4.hospitalupskill.consultas.appointment.AppointmentCreationRequest;
import com.Bgrupo4.hospitalupskill.consultas.appointment.AppointmentRepository;
import com.Bgrupo4.hospitalupskill.consultas.vaga.Vaga;
import com.Bgrupo4.hospitalupskill.consultas.vaga.VagaCreationRequest;
import com.Bgrupo4.hospitalupskill.consultas.vaga.VagaRepository;
import com.Bgrupo4.hospitalupskill.consultas.vaga.VagaService;
import com.Bgrupo4.hospitalupskill.user.doctor.Doctor;
import com.Bgrupo4.hospitalupskill.user.doctor.DoctorRepository;
import com.Bgrupo4.hospitalupskill.user.utente.Utente;
import com.Bgrupo4.hospitalupskill.user.utente.UtenteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ConsultasService {

    private final AppointmentRepository appointmentRepository;
    private final VagaRepository vagaRepository;
    private final DoctorRepository doctorRepository;
    private final UtenteRepository utenteRepository;

    public Appointment getAppointment(Long id) {
        Optional<Appointment> appointment = appointmentRepository.findById(id);
        if (appointment.isPresent()) {
            return appointment.get();
        }
        throw new EntityNotFoundException(String.format("Cant' find appointment %s", id));
    }

    public List<Appointment> getAppointments() {
        return appointmentRepository.findAll();
    }

    public List<Appointment> getAppointmentsUtente(Long id) {
        return appointmentRepository.findAllByUtenteId(id);
    }

    public Appointment createAppointment(AppointmentCreationRequest request) {
        Optional<Doctor> doctor = doctorRepository.findById(request.getDoctor());
        Optional<Utente> utente = utenteRepository.findById(request.getUtente());
        Optional<Vaga> vaga = vagaRepository.findById(request.getVaga());
        if (!doctor.isPresent() || !utente.isPresent() || !vaga.isPresent()) {
            throw new EntityNotFoundException(String.format("Utente %s, vaga %s ou Medico %s não foi encontrado",request.getUtente(), request.getVaga(), request.getDoctor()));
        }
        Appointment appointment = new Appointment();
        //yaaaaas bitch on period
        vaga.ifPresent(vaga1 -> vaga1.setFree(false));
        BeanUtils.copyProperties(request, appointment);
        appointment.setDoctor(doctor.get());
        appointment.setUtente(utente.get());
        return appointmentRepository.save(appointment);
    }

    public Appointment updateAppointment(Long id, AppointmentCreationRequest request) {
        Optional<Doctor> doctor = doctorRepository.findById(request.getDoctor());
        Optional<Utente> utente = utenteRepository.findById(request.getUtente());
        Optional<Appointment> optionalAppointment  = appointmentRepository.findById(id);
        if (!doctor.isPresent() || !utente.isPresent() || !optionalAppointment.isPresent()) {
            throw new EntityNotFoundException(String.format("Utente %s, appointment %s ou Medico %s não foi encontrado",request.getUtente(), id, request.getDoctor()));
        }
        Appointment appointment = optionalAppointment.get();
        appointment.setDate(LocalDate.parse(request.getDate()));
        appointment.setTime(LocalTime.parse(request.getTime()));
        appointment.setDoctor(doctor.get());
        appointment.setUtente(utente.get());
        appointment.setStatus(Status.valueOf(request.getStatus()));
        return appointmentRepository.save(appointment);
    }

    public Vaga cancelAppointment(Long id){
        Optional<Appointment> appointment = appointmentRepository.findById(id);
        if (!appointment.isPresent()) {
            throw new EntityNotFoundException(String.format("A marcação %s nao foi encontrada", id));
        }
        Vaga vaga = new Vaga();
        appointment.ifPresent(appointment1 -> {
            appointment1.setStatus(Status.CANCELLED);
            vaga.setDate(appointment1.getDate());
            vaga.setDoctor(appointment1.getDoctor());
            vaga.setTime(appointment1.getTime());
        });
        //todo
        //appointmentRepository.updateById();
        return vagaRepository.save(vaga);
    }

    public Vaga getVaga(Long id) {
        Optional<Vaga> vaga = vagaRepository.findById(id);
        if (vaga.isPresent()) {
            return vaga.get();
        }
        throw new EntityNotFoundException(String.format("Cant' find vaga %s", id));
    }

    public List<Vaga> getVagas() {
        return vagaRepository.findAll();
    }

    public List<Vaga> getVagas(String especialidade) {
        //return vagaRepository.findAllByEspecialidade(especialidade);
        return null;
    }

    public List<Vaga> getVagas(Long id) {
        return vagaRepository.findAllByDoctorId(id);
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
    public void deleteVaga(Long id) {
        vagaRepository.deleteById(id);
    }

    //todo
    public Vaga updateVaga(Long id, VagaService request) {
        return null;
    }
}