package com.Bgrupo4.hospitalupskill.user.utente;

import com.Bgrupo4.hospitalupskill.consultas.appointment.Appointment;
import com.Bgrupo4.hospitalupskill.user.ApplicationUser;
import com.Bgrupo4.hospitalupskill.user.UserRole;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@Entity(name = "Utente")
@Table(name = "utente",uniqueConstraints = {@UniqueConstraint(name = "utente_email_unique", columnNames = "email")})
                                            // @UniqueConstraint(name = "utente_username_unique", columnNames = "username"),
                                            //@UniqueConstraint(name = "utente_nif_unique", columnNames = "nif")})
@AllArgsConstructor
@NoArgsConstructor
public class Utente extends ApplicationUser {

    private String apolice;
    private int numUtente;

    @JsonBackReference
    @OneToMany(mappedBy = "utente",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Appointment> appointments;

    public Utente(Integer nif, String name, String username, String email, String password, String apolice, int numUtente) {
        super(nif, name, username, email, password, UserRole.UTENTE.name());
        this.apolice = apolice;
        this.numUtente = numUtente;
    }

    public Utente(String name, UserRole userRole) {
        super(name, userRole);
    }


}
