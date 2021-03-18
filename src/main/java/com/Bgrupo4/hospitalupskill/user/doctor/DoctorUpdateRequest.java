package com.Bgrupo4.hospitalupskill.user.doctor;

import lombok.Data;

@Data
public class DoctorUpdateRequest {
    private final String name;
    private final String morada;
    private final String localidade;
    private final String telemovel;
    private final String password;
}