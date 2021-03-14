package com.Bgrupo4.hospitalupskill.consultas.receitas;

import com.Bgrupo4.hospitalupskill.consultas.appointment.Appointment;
import com.Bgrupo4.hospitalupskill.consultas.appointment.AppointmentRepository;
import com.Bgrupo4.hospitalupskill.user.doctor.Doctor;
import com.Bgrupo4.hospitalupskill.user.doctor.DoctorRepository;
import com.Bgrupo4.hospitalupskill.user.utente.Utente;
import com.Bgrupo4.hospitalupskill.user.utente.UtenteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReceitaService {

    private final ReceitaRepository receitaRepository;
    private final DoctorRepository doctorRepository;
    private final AppointmentRepository appointmentRepository;
    private final UtenteRepository utenteRepository;
    private final MedicamentoRepository medicamentoRepository;

    public Receita createReceita(Appointment appointment) {
        Optional<Appointment> appointmentOptional = appointmentRepository.findById(appointment.getId());
        if (appointmentOptional.isEmpty()) {
            throw new EntityNotFoundException(String.format("A consulta %s não existe", appointment.getId()));
        }
        Optional<Doctor> doctor = doctorRepository.findById(appointmentOptional.get().getDoctor().getId());
        Optional<Utente> utente = utenteRepository.findById(appointmentOptional.get().getUtente().getId());
        if (doctor.isEmpty() || utente.isEmpty()) {
            throw new EntityNotFoundException(String.format("O medico %s ou o utente %s não existe", appointmentOptional.get().getDoctor().getId(), appointmentOptional.get().getUtente().getId()));
        }

        Receita receita = new Receita();
        receita.setDoctor(doctor.get());
        receita.setUtente(utente.get());
        receita.setAppointment(appointmentOptional.get());
        receita.setDate(Calendar.getInstance().getTime());
        return receitaRepository.save(receita);
    }


    public Medicamento addMedicamento(Medicamento medicamento, Receita receita) {
        Optional<Receita> receitaOptional = receitaRepository.findById(receita.getId());
        if (receitaOptional.isEmpty()) {
            throw new EntityNotFoundException(String.format("A receita %s não existe", receita.getId()));
        }
        medicamento.setReceita(receitaOptional.get());
        medicamento.setUtente(receitaOptional.get().getUtente());
        return medicamentoRepository.save(medicamento);
    }


    public List<Receita> getReceitasByUtente(Long id) {
        return receitaRepository.findAllByUtenteId(id);
    }

    public List<Medicamento> getMedicamentosByReceita(Long id) {
        return medicamentoRepository.findAllByReceita(id);
    }

    public List<Receita> getReceitasByUtenteOrderByDate(Utente utente) {
        return receitaRepository.findAllByUtenteOrderByDateAsc(utente);
    }
}
