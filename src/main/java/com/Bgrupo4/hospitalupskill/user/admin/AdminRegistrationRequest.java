package com.Bgrupo4.hospitalupskill.user.admin;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class AdminRegistrationRequest {
    private final String nif;
    private final String name;
    private final String username;
    private final String email;
    private final String password;
    private final String morada;
    private final String localidade;
    private final String telemovel;
    private final String dataDeNascimento;
    private final String cedula;
    private final String especialidade;
    private final String role;

}