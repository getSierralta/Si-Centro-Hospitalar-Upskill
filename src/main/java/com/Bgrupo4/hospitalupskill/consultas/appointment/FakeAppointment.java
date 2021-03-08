package com.Bgrupo4.hospitalupskill.consultas.appointment;

import com.Bgrupo4.hospitalupskill.user.doctor.FakeDoctor;
import lombok.Getter;

@Getter
public class FakeAppointment {

    private String id = "";

    private String date = "Não tem consultas marcadas";

    private String time = "";

    private FakeDoctor doctor = new FakeDoctor();

    private String especialidade = "";

}
