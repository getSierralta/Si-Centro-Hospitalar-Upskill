package com.Bgrupo4.hospitalupskill.senha;

import com.Bgrupo4.hospitalupskill.consultas.appointment.Appointment;
import com.Bgrupo4.hospitalupskill.user.utente.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface SenhaRepository extends JpaRepository<Senha, Long> {

    @Query("SELECT u FROM Senha u WHERE u.date = ?1 AND u.foiAtentido = 0")
    List<Senha> getAllValidSenhas(Date time);

    List<Senha> getAllByAppointment(Appointment appointment);

    @Query("SELECT u FROM Senha u WHERE u.utente = ?1 AND u.date = ?2 AND u.foiAtentido = 0")
    List<Senha> getAllByUtenteAndDate(Utente utente, Date now);
}
