package com.Bgrupo4.hospitalupskill.user;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.sql.Date;
import java.util.Collection;
import java.util.Collections;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class User implements UserDetails {

    @Id
    private Integer nUtente;
    private String name;
    private String username;
    private String email;
    private String password;
    private String morada;
    private String localidade;
    private int phone;
    private Date birthDay;
    private String profilePicture = "";
    @Enumerated(EnumType.STRING)
    private UserRole userRole;
    private Boolean locked;
    private Boolean enabled;

    public User(Integer nUtente,
                String name,
                String username,
                String email,
                String password,
                String morada,
                String localidade,
                int phone,
                Date birthDay,
                UserRole userRole,
                Boolean locked,
                Boolean enabled) {
        this.nUtente = nUtente;
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.morada = morada;
        this.localidade = localidade;
        this.phone = phone;
        this.birthDay = birthDay;
        this.userRole = userRole;
        this.locked = locked;
        this.enabled = enabled;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(userRole.name());
        return Collections.singletonList(authority);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
