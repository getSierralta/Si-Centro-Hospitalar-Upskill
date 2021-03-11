package com.Bgrupo4.hospitalupskill.consultas.appointment;

import lombok.Data;

import java.util.Calendar;


@Data
public class AppointmentCreationRequest {
    private Long vaga;
    private Calendar date;
    private Long doctor;
    private Long utente;
    private String status;

}
