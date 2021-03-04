package com.Bgrupo4.hospitalupskill.user.employee;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.sql.Date;

public class Unidade {

    @Id
    private Integer id;
    private String name;
    private String email;
    private String morada;
    private String localidade;
    private String phone;
    private String picture;

    public Unidade(Integer id, String name, String email, String morada, String localidade, String phone, String picture) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.morada = morada;
        this.localidade = localidade;
        this.phone = phone;
        this.picture = picture;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
