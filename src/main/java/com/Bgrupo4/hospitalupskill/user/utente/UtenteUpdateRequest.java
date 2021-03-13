package com.Bgrupo4.hospitalupskill.user.utente;

import lombok.*;

@Data
public class UtenteUpdateRequest {
    private final String name;
    private final String morada;
    private final String localidade;
    private final String telemovel;
    private final String apolice;
    private final String password;
}