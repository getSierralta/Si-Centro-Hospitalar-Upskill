package com.Bgrupo4.hospitalupskill.senha;

import com.Bgrupo4.hospitalupskill.consultas.appointment.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface SenhaRepository extends JpaRepository<Senha, Long> {

    @Query("SELECT u FROM Senha u WHERE u.date = ?1 AND u.foiAtentido = 0")
    List<Senha> getAllValidSenhas(Date time);

    List<Senha> getAllByAppointment(Appointment appointment);
}
