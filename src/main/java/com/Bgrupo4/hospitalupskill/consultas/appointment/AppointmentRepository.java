package com.Bgrupo4.hospitalupskill.consultas.appointment;

import com.Bgrupo4.hospitalupskill.consultas.Status;
import com.Bgrupo4.hospitalupskill.consultas.vaga.Vaga;
import com.Bgrupo4.hospitalupskill.user.doctor.Doctor;
import com.Bgrupo4.hospitalupskill.user.utente.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.GregorianCalendar;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    //todo
    //void updateById(Long id);
    List<Appointment> findAllByUtenteId(Long id);

    @Query("Select u from Appointment u where u.utente = ?1 and u.status = 'OPEN' order by DATE ASC")
    List<Appointment> findAllByUtenteOrderByDateAsc(Utente utente);

    List<Vaga> findAllByEspecialidade(String especialidade);

    List<Appointment> findAllByUtenteAndDate(Utente utente, GregorianCalendar gregorianCalendar);

    List<Appointment> findAllByDoctorAndStatus(Doctor doctor, Status going);

    List<Appointment> findAllByDoctorAndDate(Doctor doctor, GregorianCalendar gregorianCalendar);
}
