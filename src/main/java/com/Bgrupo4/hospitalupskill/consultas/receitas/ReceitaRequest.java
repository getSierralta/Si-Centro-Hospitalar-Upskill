package com.Bgrupo4.hospitalupskill.consultas.receitas;

import lombok.Data;

@Data
public class ReceitaRequest {
    private Long vaga;
    private String date;
    private String time;
    private Long doctor;
    private Long utente;
    private String status;

}
