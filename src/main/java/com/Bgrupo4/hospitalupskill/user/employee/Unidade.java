package com.Bgrupo4.hospitalupskill.user.employee;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity(name = "Unidade")
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


}
