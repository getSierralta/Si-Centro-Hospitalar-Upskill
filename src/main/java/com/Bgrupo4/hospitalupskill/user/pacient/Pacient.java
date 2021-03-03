package com.Bgrupo4.hospitalupskill.user.pacient;

import com.Bgrupo4.hospitalupskill.user.User;
import com.Bgrupo4.hospitalupskill.user.UserRole;

import javax.persistence.Id;
import java.sql.Date;

public class Pacient extends User {

    @Id
    private Integer numUtente;
    private String apolice;

    public Pacient(Integer utente, String name, String username, String email, String password, String morada, String localidade, String phone, Date birthday, UserRole userRole, Integer numUtente, String apolice) {
        super(utente, name, username, email, password, morada, localidade, phone, birthday, userRole);
        this.numUtente = numUtente;
        this.apolice = apolice;
    }

    public Integer getNumUtente() {
        return numUtente;
    }

    public void setNumUtente(Integer numUtente) {
        this.numUtente = numUtente;
    }

    public String getApolice() {
        return apolice;
    }

    public void setApolice(String apolice) {
        this.apolice = apolice;
    }
}
