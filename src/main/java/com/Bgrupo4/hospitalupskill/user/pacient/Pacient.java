package com.Bgrupo4.hospitalupskill.user.pacient;

import com.Bgrupo4.hospitalupskill.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
public class Pacient extends User {

    @Id
    private Integer numUtente;
    private String apolice;
}
