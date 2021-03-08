package com.Bgrupo4.hospitalupskill.registration;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class RegistrationRequest {
    private final Integer nif;
    private final String name;
    private final String username;
    private final String email;
    private final String password;
    private final String apolice;
    private final Integer numUtente;
    /*
    private String morada;
    private String localidade;
    private int phone;
    private Date birthDay;
     */
}