package com.Bgrupo4.hospitalupskill.user.utente;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class UtenteRequest {

    private final String name;
    private final String username;
    private final String apolice;
}
