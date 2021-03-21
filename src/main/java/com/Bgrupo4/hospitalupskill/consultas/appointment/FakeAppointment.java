package com.Bgrupo4.hospitalupskill.consultas.appointment;

import com.Bgrupo4.hospitalupskill.user.doctor.Doctor;
import lombok.Getter;


@Getter
public class FakeAppointment {

    private String id = "";

    private String date = "Não tem consultas marcadas";

    private String time = "";

    private String especialidade = "";

    private Doctor doctor = new Doctor();

    private String utente = "";

    private Appointment appointment = new Appointment();

    private String description = "";

    public String getDataString(){
        return "Não tem consultas marcadas";
    }


}
