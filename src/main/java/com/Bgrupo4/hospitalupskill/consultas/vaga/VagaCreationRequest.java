package com.Bgrupo4.hospitalupskill.consultas.vaga;

import lombok.Data;

@Data
public class VagaCreationRequest {
    private String date;
    private String time;
    private Long doctor;
}
