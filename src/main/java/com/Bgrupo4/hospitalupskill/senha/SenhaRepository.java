package com.Bgrupo4.hospitalupskill.senha;

import com.Bgrupo4.hospitalupskill.consultas.appointment.Appointment;
import com.Bgrupo4.hospitalupskill.user.doctor.Doctor;
import com.Bgrupo4.hospitalupskill.user.employee.Employee;
import com.Bgrupo4.hospitalupskill.user.utente.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface SenhaRepository extends JpaRepository<Senha, Long> {

    @Query("SELECT u FROM Senha u WHERE u.data = ?1 AND u.foiAtentido = 0")
    List<Senha> getAllValidSenhas(Date time);

    List<Senha> getAllByAppointment(Appointment appointment);

    @Query("SELECT u FROM Senha u WHERE u.utente = ?1 AND u.data = ?2 AND u.foiAtentido = 0")
    List<Senha> getAllByUtenteAndDate(Utente utente, Date now);

    @Query("SELECT u FROM Senha u WHERE u.doctor = ?1 AND u.data = ?2 AND u.foiAtentido = 0")
    List<Senha> getAllByDoctorAndDate(Doctor doctor, Date time);

    List<Senha> getAllByDoctorAndStatus(Doctor doctor, String name);

    @Query("SELECT u FROM Senha u WHERE u.data = ?1 AND u.categoria = ?2 AND u.foiAtentido = 0")
    List<Senha> getAllValidSenhasByCategoria(Date time, String name);

    @Query("SELECT u FROM Senha u WHERE u.colaborador = ?1 AND u.data = ?2")
    List<Senha> getAllByEmployeeAndDate(Employee employee, Date time);

    List<Senha> findAllByStatusAndData(String name, Date time);

    @Query("SELECT u FROM Senha u WHERE u.data = ?1 AND u.foiAtentido = 1")
    List<Senha> findAllAtendidas(Date time);
}
