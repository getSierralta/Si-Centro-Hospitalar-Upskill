package com.Bgrupo4.hospitalupskill.user.employee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@Entity
public class Hospital {

    @Id
    private Integer id;
    private String name;
    private String email;
    private String morada;
    private String localidade;
    private String phone;
    private String picture;

}
