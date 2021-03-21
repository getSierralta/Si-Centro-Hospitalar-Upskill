package com.Bgrupo4.hospitalupskill.consultas;

import com.Bgrupo4.hospitalupskill.consultas.appointment.Appointment;
import com.Bgrupo4.hospitalupskill.consultas.appointment.AppointmentCreationRequest;
import com.Bgrupo4.hospitalupskill.consultas.appointment.AppointmentRepository;
import com.Bgrupo4.hospitalupskill.consultas.receitas.Receita;
import com.Bgrupo4.hospitalupskill.consultas.receitas.ReceitaRepository;
import com.Bgrupo4.hospitalupskill.consultas.receitas.ReceitaRequest;
import com.Bgrupo4.hospitalupskill.consultas.relatorio.Relatorio;
import com.Bgrupo4.hospitalupskill.consultas.relatorio.RelatorioRepository;
import com.Bgrupo4.hospitalupskill.consultas.relatorio.RelatorioRequest;
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

import static com.Bgrupo4.hospitalupskill.HospitalUpskillApplication.ECRA;

@Service
@RequiredArgsConstructor
public class ConsultasService {

    private final AppointmentRepository appointmentRepository;
    private final VagaRepository vagaRepository;
    private final DoctorRepository doctorRepository;
    private final UtenteRepository utenteRepository;
    private final SenhaRepository senhaRepository;
    private final RelatorioRepository relatorioRepository;
    private final ReceitaRepository receitaRepository;

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
        updateVaga(vaga.get().getId(), false);
        BeanUtils.copyProperties(request, appointment);
        appointment.setDoctor(doctor.get());
        appointment.setUtente(utente.get());
        appointment.setDate(vaga.get().getDate());
        appointment.setData(vaga.get().getData());
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
        updateVaga(vaga.getId(), false);
        appointment.setDate(vagaOptional.get().getDate());
        appointment.setData(vagaOptional.get().getData());
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
            appointment.setData(vaga.getData());
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
            Appointment appointment1 = appointment.get();
            appointment1.setStatus(Status.CANCELLED);
            if (appointment.get().getData().getTime().after(Calendar.getInstance().getTime())){
                Vaga vaga = new Vaga();
                vaga.setDate(appointment1.getDate());
                vaga.setData(appointment1.getData());
                vaga.setDoctor(appointment1.getDoctor());
                vaga.setEspecialidade(appointment1.getDoctor().getEspecialidade().getEspecialidade());
                vaga.setDate(appointment1.getDate());
                vaga.setTime(appointment1.getTime());
                vagaRepository.save(vaga);
            }
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
        return appointmentRepository.findAllByUtenteAndData(utente, new GregorianCalendar(Integer.parseInt(split[0]), Integer.parseInt(month), Integer.parseInt(day)));
    }

    public Appointment startConsulta(Senha senha) {
        Optional<Appointment> appointmentOptional = appointmentRepository.findById(senha.getAppointment().getId());
        if (appointmentOptional.isEmpty()){
            throw new EntityNotFoundException("Consulta não encontrada: "+senha.getAppointment().getId());
        }
        Appointment appointment = appointmentOptional.get();
        appointment.setStatus(Status.GOING);
        appointment.setStartedAt(String.valueOf(LocalDate.now()));

        if (appointment.getStartedAt() != null){
            appointment.setStartedAt(String.valueOf(LocalTime.now()));
        }
        senha.setFoiAtentido(true);
        senha.setStatus(Status.GOING.name());
        senhaRepository.save(senha);
        ECRA.add(senha.getNumeroSenha());
        return appointmentRepository.save(appointment);
    }

    public Relatorio createRelatorio(Doctor doctor, Utente utente, RelatorioRequest request) {
        if (request.getRelatorio() != null){
            Relatorio relatorio = new Relatorio();
            relatorio.setDate(Calendar.getInstance().getTime());
            relatorio.setDoctor(doctor);
            relatorio.setUtente(utente);
            relatorio.setDescription(request.getRelatorio());
            return relatorioRepository.save(relatorio);
        }
        throw new IllegalArgumentException("No description");
    }

    public Receita createReceita(Doctor doctor, Utente utente, ReceitaRequest request) {
        if (request.getRelatorio() != null){
            Receita receita = new Receita();
            receita.setDate(Calendar.getInstance().getTime());
            receita.setDoctor(doctor);
            receita.setUtente(utente);
            receita.setDescription(request.getRelatorio());
            return receitaRepository.save(receita);
        }
        throw new IllegalArgumentException("No Receita");
    }

    public Appointment marcarAusencia(Long id) {
        Optional<Appointment> appointmentOptional = appointmentRepository.findById(id);
        if (appointmentOptional.isEmpty()){
            throw new EntityNotFoundException("Consulta não existe" + id);
        }
        Appointment appointment = appointmentOptional.get();
        appointment.setStatus(Status.LATE);
        List<Senha> senhaOptional = senhaRepository.getAllByAppointment(appointment);
        for (Senha senha: senhaOptional) {
            ECRA.remove(senha.getNumeroSenha());
        }
        return appointmentRepository.save(appointment);
    }

    public Appointment fecharConsulta(Long id) {
        Optional<Appointment> appointmentOptional = appointmentRepository.findById(id);
        if (appointmentOptional.isEmpty()){
            throw new EntityNotFoundException("Consulta não existe" + id);
        }
        Appointment appointment = appointmentOptional.get();
        appointment.setStatus(Status.CLOSED);

        for (Senha senha :  getSenhasOnGoingAppoinmentByMedico(appointment.getDoctor())) {
            if (senha.getAppointment().getId().equals(appointment.getId())){
                senha.setStatus(Status.CLOSED.name());
                senhaRepository.save(senha);
                ECRA.remove(senha.getNumeroSenha());
                break;
            }
        }
        return appointmentRepository.save(appointment);
    }

    public List<Senha> getSenhasOnGoingAppoinmentByMedico(Doctor doctor) {
        List<Senha> senhas = new ArrayList<>();
        for (Appointment appointment: appointmentRepository.findAllByDoctorAndStatus(doctor, Status.GOING)){
            senhas.addAll(senhaRepository.getAllByAppointment(appointment));
        }
        return senhas;
    }

    public List<Senha> getSenhasLateAppoinmentByMedico(Doctor doctor) {
        List<Senha> senhas = new ArrayList<>();
        for (Appointment appointment: appointmentRepository.findAllByDoctorAndStatus(doctor, Status.LATE)){
            senhas.addAll(senhaRepository.getAllByAppointment(appointment));
        }
        return senhas;
    }


    public List<Appointment> getAppointmentsMedicoByDate(Doctor doctor, String dia) {
        String[] split = dia.split("-");
        String[] m = split[1].split("");
        String[] d = split[2].split("");
        String month = m.length == 2 ? split[1] : "0" + split[1];
        String day = d.length == 2 ? split[2] : "0" + split[2];
        return appointmentRepository.findAllByDoctorAndData(doctor, new GregorianCalendar(Integer.parseInt(split[0]), Integer.parseInt(month), Integer.parseInt(day)));
    }
}

