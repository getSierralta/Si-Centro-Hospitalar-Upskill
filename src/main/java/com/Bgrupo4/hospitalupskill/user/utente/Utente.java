package com.Bgrupo4.hospitalupskill.user.utente;

import com.Bgrupo4.hospitalupskill.user.ApplicationUser;
import com.Bgrupo4.hospitalupskill.user.UserRole;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Getter
@Setter
@Entity(name = "Utente")
@Table(name = "utente",uniqueConstraints = {@UniqueConstraint(name = "utente_email_unique", columnNames = "email")})
                                            // @UniqueConstraint(name = "utente_username_unique", columnNames = "username"),
                                            //@UniqueConstraint(name = "utente_nif_unique", columnNames = "nif")})
public class Utente extends ApplicationUser {

    private String apolice;

    //For some reason this doesnt work if i dont have an empty constructor
    public Utente() {
    }

    public Utente(Integer nif, String name, String username, String email, String password, String apolice) {
        super(nif, name, username, email, password, UserRole.UTENTE.name());
        this.apolice = apolice;
    }

}
