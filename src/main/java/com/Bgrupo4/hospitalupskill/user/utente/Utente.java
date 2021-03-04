package com.Bgrupo4.hospitalupskill.user.utente;

import com.Bgrupo4.hospitalupskill.user.ApplicationUser;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Utente extends ApplicationUser {

    private String apolice;

    public Utente(Integer nif, String name, String username, String email, String password, String role, String apolice) {
        super(nif, name, username, email, password, role);
        this.apolice = apolice;
    }

}
