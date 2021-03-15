package com.Bgrupo4.hospitalupskill.consultas.appointment;

import com.Bgrupo4.hospitalupskill.consultas.vaga.Vaga;
import com.Bgrupo4.hospitalupskill.user.utente.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.GregorianCalendar;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    //todo
    //void updateById(Long id);
    List<Appointment> findAllByUtenteId(Long id);

    List<Appointment> findAllByUtenteOrderByDateAsc(Utente utente);

    List<Vaga> findAllByEspecialidade(String especialidade);

    List<Appointment> findAllByUtenteAndDate(Utente utente, GregorianCalendar gregorianCalendar);
}
