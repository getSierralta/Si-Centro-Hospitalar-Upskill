package com.Bgrupo4.hospitalupskill.consultas.appointment;

import lombok.Data;



@Data
public class AppointmentCreationRequest {
    private Long vaga;
    private String date;
    private Long doctor;
    private Long utente;
    private String status;

}
