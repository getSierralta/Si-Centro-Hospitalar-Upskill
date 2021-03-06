package com.Bgrupo4.hospitalupskill.user.admin;

import lombok.*;

@Data
public class AdminRequest {
    private final String nif;
    private final String name;
    private final String username;
    private final String email;
    private final String password;
    private final String morada;
    private final String localidade;
    private final String telemovel;
    private final String dataDeNascimento;
    private final String role;
}