package com.Bgrupo4.hospitalupskill.consultas.appointment;

import com.Bgrupo4.hospitalupskill.consultas.receitas.Medicamento;
import com.Bgrupo4.hospitalupskill.consultas.receitas.ReceitaStatus;
import com.Bgrupo4.hospitalupskill.user.doctor.Doctor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class FakeAppointment {

    private String id = "";

    private String date = "Não tem consultas marcadas";

    private String especialidade = "";

    private Doctor doctor = new Doctor();

    private String utente = "";

    private Appointment appointment = new Appointment();

    private List<Medicamento> medicamentos = new ArrayList<>();


}
