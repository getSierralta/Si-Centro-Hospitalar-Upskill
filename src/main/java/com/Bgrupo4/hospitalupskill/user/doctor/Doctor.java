package com.Bgrupo4.hospitalupskill.user.doctor;

import com.Bgrupo4.hospitalupskill.user.ApplicationUser;
import com.Bgrupo4.hospitalupskill.user.employee.Employee;
import com.Bgrupo4.hospitalupskill.user.employee.Unidade;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity(name = "Doctor")
@Table(name = "doctor", uniqueConstraints = {@UniqueConstraint(name = "doctor_email_unique", columnNames = "email")})
// @UniqueConstraint(name = "user_username_unique", columnNames = "username"),
//@UniqueConstraint(name = "user_nif_unique", columnNames = "nif")})
public class Doctor extends ApplicationUser {


    private String cedula;
    //private List<Especialidade> especialidades;
    /*@OneToMany
    @JoinColumn(nullable = false,name = "unidade")
    private Unidade unidade;*/

    public Doctor() {
    }

    public Doctor(Integer nif, String name, String username, String email, String password, String role, Unidade unidade, String cedula, List<Especialidade> especialidades) {
        super(nif, name, username, email, password, role);
        this.cedula = cedula;
        //this.especialidades = especialidades;
        //this.unidade = unidade;
    }
}


