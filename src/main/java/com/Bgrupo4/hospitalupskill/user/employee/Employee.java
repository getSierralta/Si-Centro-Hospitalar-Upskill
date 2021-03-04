package com.Bgrupo4.hospitalupskill.user.employee;

import com.Bgrupo4.hospitalupskill.user.ApplicationUser;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.Collections;

@Getter
@Setter
public class Employee extends ApplicationUser {

    private Unidade unidade;

    public Employee(Integer nif, String name, String username, String email, String password, String role, Unidade unidade) {
        super(nif, name, username, email, password, role);
        this.unidade = unidade;
    }
}
