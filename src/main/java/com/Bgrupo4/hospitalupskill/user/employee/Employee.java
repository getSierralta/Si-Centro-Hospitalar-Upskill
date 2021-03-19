package com.Bgrupo4.hospitalupskill.user.employee;

import com.Bgrupo4.hospitalupskill.senha.Senha;
import com.Bgrupo4.hospitalupskill.user.ApplicationUser;
import com.Bgrupo4.hospitalupskill.user.UserRole;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
@Entity(name = "Employee")
@Table(name = "employee",uniqueConstraints = {@UniqueConstraint(name = "employee_email_unique", columnNames = "email"),
                                                 @UniqueConstraint(name = "user_username_unique", columnNames = "username"),
                                                @UniqueConstraint(name = "user_nif_unique", columnNames = "nif")})
public class Employee extends ApplicationUser {


    @JsonBackReference
    @OneToMany(mappedBy = "colaborador",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Senha> senhas;

    public Employee() {
    }


    public Employee(String nif, String name, String username, String email, String password, String morada, String localidade, String phone, Calendar birthday, String role) {
        super(nif, name, username, email, password, morada, localidade, phone, birthday, role);
    }
}
