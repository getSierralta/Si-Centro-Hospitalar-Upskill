package com.Bgrupo4.hospitalupskill.user;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;

import java.util.Date;
import java.util.Collection;
import java.util.Collections;

import static javax.persistence.GenerationType.SEQUENCE;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity(name = "User")
@Table(
        name = "user",
        uniqueConstraints = {
                @UniqueConstraint(name = "user_email_unique", columnNames = "email")
        }
)
public class User implements UserDetails {

    @Id
    @SequenceGenerator(name = "user_sequence",
        sequenceName = "user_sequence",
        allocationSize = 1)
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "user_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;
    @Column(name = "nUtente")
    private Integer utente;
    @Column(
            name= "nome",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String name;
    @Column(
            name= "username",
            columnDefinition = "TEXT"
    )
    private String username;
    @Column(
            name= "email",
            nullable = false
    )
    private String email;
    @Column(name = "password")
    private String password;
    @Column(
            name= "morada",
            columnDefinition = "TEXT"
    )
    private String morada;
    @Column(
            name= "localidade",
            columnDefinition = "TEXT"
    )
    private String localidade;
    @Column (name = "phone")
    private String phone;
    @Column(
            name= "birthday",
            columnDefinition = "TEXT"
    )
    private Date birthday;
    @Enumerated(EnumType.STRING)
    private UserRole userRole = UserRole.USER;
    private Boolean locked = false;
    private Boolean enabled = false;
    private String profilePicture = "";


    //Test purposes


    public User(Integer utente, String name, String email) {
        this.utente = utente;
        this.name = name;
        this.email= email;
    }

    public User(Integer utente,
                String name,
                String username,
                String email,
                String password) {
        this.utente = utente;
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User(Integer utente,
                String name,
                String username,
                String email,
                String password,
                String morada,
                String localidade,
                String _phone,
                Date birthday,
                UserRole userRole) {
        this.utente = utente;
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.userRole = userRole;
        this.morada = morada;
        this.localidade = localidade;
        this.phone = _phone;
        this.birthday = birthday;
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

    @Override
    public String toString() {
        return "User{" +
                "utente=" + utente +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", morada='" + morada + '\'' +
                ", localidade='" + localidade + '\'' +
                ", phone='" + phone + '\'' +
                ", birthday=" + birthday +
                ", userRole=" + userRole +
                ", locked=" + locked +
                ", enabled=" + enabled +
                ", profilePicture='" + profilePicture + '\'' +
                '}';
    }
}
