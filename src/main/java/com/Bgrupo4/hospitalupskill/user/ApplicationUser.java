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
@Table(name = "user",uniqueConstraints = {@UniqueConstraint(name = "user_email_unique", columnNames = "email")})
                                           // @UniqueConstraint(name = "user_username_unique", columnNames = "username"),
                                            //@UniqueConstraint(name = "user_nif_unique", columnNames = "nif")})
public class ApplicationUser implements UserDetails {

    @Id
    @SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "user_sequence")
    @Column(name = "id",updatable = false)
    private Long id;

    @Column(name = "nif")
    private Integer nif;

    @Column(name= "nome", nullable = false, columnDefinition = "TEXT")
    private String name;

    @Column(name= "username", columnDefinition = "TEXT")
    private String username;

    @Column(name= "email", nullable = false)
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name= "morada", columnDefinition = "TEXT")
    private String morada;

    @Column(name= "localidade", columnDefinition = "TEXT")
    private String localidade;

    @Column (name = "phone")
    private String phone;

    @Column(name= "birthday", columnDefinition = "TEXT")
    private Date birthday;

    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    private String profilePicture = "";

    private Boolean locked = false;
    private Boolean enabled = false;
    private final boolean isAccountNonExpired = true;
    private final boolean isCredentialsNonExpired = true;

    //Test purposes
    public ApplicationUser(Integer nif,
                           String name,
                           String username,
                           String email,
                           String password,
                           String role) {
        this.nif = nif;
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.userRole = getRole(role);
    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return userRole.getGrantedAuthorities();
    }


    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    private UserRole getRole(String role){
        switch (role){
            case "UTENTE":
                return UserRole.UTENTE;
            case "MEDICO":
                return UserRole.MEDICO;
            case "RESPONSAVEL":
                return UserRole.RESPONSAVEL;
            case "COLABORADOR":
                return UserRole.COLABORADOR;
            case "ADMIN":
                return UserRole.ADMIN;
            case "MEDICO_RESPONSAVEL":
                return UserRole.MEDICO_RESPONSAVEL;
            case "COLABORADOR_RESPONSAVEL":
                return UserRole.COLABORADOR_RESPONSAVEL;
            default:
                return UserRole.USER;
        }
    }

    @Override
    public String toString() {
        return "ApplicationUser{" +
                "id=" + id +
                ", nif=" + nif +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", morada='" + morada + '\'' +
                ", localidade='" + localidade + '\'' +
                ", phone='" + phone + '\'' +
                ", birthday=" + birthday +
                ", userRole=" + userRole +
                ", profilePicture='" + profilePicture + '\'' +
                ", locked=" + locked +
                ", enabled=" + enabled +
                ", isAccountNonExpired=" + isAccountNonExpired +
                ", isCredentialsNonExpired=" + isCredentialsNonExpired +
                '}';
    }
}
