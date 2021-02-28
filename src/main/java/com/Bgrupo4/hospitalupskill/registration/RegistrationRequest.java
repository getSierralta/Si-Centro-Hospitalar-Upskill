package com.Bgrupo4.hospitalupskill.registration;

import com.Bgrupo4.hospitalupskill.user.UserRole;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.sql.Date;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class RegistrationRequest {

    private int nUtente;
    private String name;
    private String username;
    private String email;
    private String password;
    private String morada;
    private String localidade;
    private int phone;
    private Date birthDay;
    private UserRole userRole;
    private Boolean locked;
    private Boolean enabled;
}
