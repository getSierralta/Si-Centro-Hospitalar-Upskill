package com.Bgrupo4.hospitalupskill.consultas.appointment;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    //todo
    //void updateById(Long id);
    List<Appointment> findAllByUtenteId(Long id);
}
