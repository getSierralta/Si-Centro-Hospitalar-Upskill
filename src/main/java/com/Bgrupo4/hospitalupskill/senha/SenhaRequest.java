package com.Bgrupo4.hospitalupskill.senha;

import com.Bgrupo4.hospitalupskill.consultas.appointment.Appointment;
import lombok.Data;

@Data
public class SenhaRequest {
    private String utenteUsername;
    private String doctorUsername;
    private String appointment;
    private String categoria;

}
