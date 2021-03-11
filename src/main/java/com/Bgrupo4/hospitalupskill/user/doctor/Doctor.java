package com.Bgrupo4.hospitalupskill.user.doctor;

import com.Bgrupo4.hospitalupskill.consultas.appointment.Appointment;
import com.Bgrupo4.hospitalupskill.consultas.receitas.Receita;
import com.Bgrupo4.hospitalupskill.consultas.vaga.Vaga;
import com.Bgrupo4.hospitalupskill.user.ApplicationUser;
import com.Bgrupo4.hospitalupskill.user.UserRole;
import com.Bgrupo4.hospitalupskill.user.employee.Unidade;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.Calendar;
import java.util.List;

@Getter
@Setter
@Entity(name = "Doctor")
@Table(name = "doctor", uniqueConstraints = {@UniqueConstraint(name = "doctor_email_unique", columnNames = "email")})
// @UniqueConstraint(name = "user_username_unique", columnNames = "username"),
//@UniqueConstraint(name = "user_nif_unique", columnNames = "nif")})
@NoArgsConstructor
public class Doctor extends ApplicationUser {


    private String cedula;

    @JsonBackReference
    @OneToMany(mappedBy = "doctor",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Appointment> appointments;

    @JsonBackReference
    @OneToMany(mappedBy = "doctor",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Vaga> vagas;

    @JsonBackReference
    @OneToMany(mappedBy = "doctor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Receita> receitas;

    @Column(name= "especialidade", nullable = false, columnDefinition = "TEXT")
    private String especialidade;

    /*@OneToMany
    @JoinColumn(nullable = false,name = "unidade")
    private Unidade unidade;*/

    public Doctor(String nif, String name, String username, String email, String password, String role, String cedula) {
        super(nif, name, username, email, password, role);
        this.cedula = cedula;
    }

    public Doctor(String nif, String name, String username, String email, String password, String role, Unidade unidade, String cedula, String especialidade) {
        super(nif, name, username, email, password, role);
        this.cedula = cedula;
        this.especialidade = especialidade;
        //this.unidade = unidade;
    }

    public Doctor(String nif, String name, String username, String email, String password, String morada, String localidade, String phone, Calendar birthday, String cedula, String especialidade) {
        super(nif, name, username, email, password, morada, localidade, phone, birthday, UserRole.MEDICO.name());
        this.cedula = cedula;
        this.especialidade = especialidade;
    }
}


