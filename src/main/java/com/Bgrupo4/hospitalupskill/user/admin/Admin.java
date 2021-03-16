package com.Bgrupo4.hospitalupskill.user.admin;

import com.Bgrupo4.hospitalupskill.user.ApplicationUser;
import com.Bgrupo4.hospitalupskill.user.employee.Unidade;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.util.Calendar;

@Getter
@Setter
@Entity(name = "Admin")
@Table(name = "admin",uniqueConstraints = {@UniqueConstraint(name = "admin_email_unique", columnNames = "email")})
                                                // @UniqueConstraint(name = "admin_username_unique", columnNames = "username"),
                                                //@UniqueConstraint(name = "admin_nif_unique", columnNames = "nif")})
public class Admin extends ApplicationUser {

    /*
    @OneToMany
    @JoinColumn(nullable = false,name = "unidade")
    private Unidade unidade;*/

    public Admin() {
    }


    public Admin(String nif, String name, String username, String email, String password, String morada, String localidade, String phone, Calendar birthday, String role) {
        super(nif, name, username, email, password, morada, localidade, phone, birthday, role);
    }


}
