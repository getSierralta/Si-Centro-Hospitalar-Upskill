package com.Bgrupo4.hospitalupskill.user.employee;

import com.Bgrupo4.hospitalupskill.user.ApplicationUser;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;

@Getter
@Setter
@Entity(name = "Employee")
@Table(name = "employee",uniqueConstraints = {@UniqueConstraint(name = "employee_email_unique", columnNames = "email")})
                                                // @UniqueConstraint(name = "user_username_unique", columnNames = "username"),
                                                //@UniqueConstraint(name = "user_nif_unique", columnNames = "nif")})
public class Employee extends ApplicationUser {

    /*
    @OneToMany
    @JoinColumn(nullable = false,name = "unidade")
    private Unidade unidade;*/

    public Employee() {
    }

    public Employee(Integer nif, String name, String username, String email, String password, String role, Unidade unidade) {
        super(nif, name, username, email, password, role);
        //this.unidade = unidade;
    }
}
