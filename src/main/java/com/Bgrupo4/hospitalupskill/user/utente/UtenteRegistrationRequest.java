package com.Bgrupo4.hospitalupskill.user.utente;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.Date;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class UtenteRegistrationRequest {
    private final String nif;
    private final String numUtente;
    private final String name;
    private final String username;
    private final String email;
    private final String password;
    private final String apolice;
    private final String morada;
    private final String localidade;
    private final String telemovel;
    private final String dataDeNascimento;

}