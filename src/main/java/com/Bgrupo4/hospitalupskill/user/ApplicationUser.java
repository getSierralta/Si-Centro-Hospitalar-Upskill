package com.Bgrupo4.hospitalupskill.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;

import java.util.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@MappedSuperclass
public class ApplicationUser implements UserDetails {

    @Id
    @SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "user_sequence")
    @Column(name = "id",updatable = false)
    private Long id;

    @Column(name = "nif", nullable = false)
    private String nif;

    @Column(name= "nome", nullable = false, columnDefinition = "TEXT")
    private String name;

    @Column(name= "username", nullable = false)
    private String username;

    //@Email
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

    @Column(name= "dataDeNascimento")
    @Temporal(TemporalType.DATE)
    private Calendar dataDeNascimento;

    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    private String profilePicture = setPic();

    private Boolean locked = false;
    private Boolean enabled = false;
    private final boolean isAccountNonExpired = true;
    private final boolean isCredentialsNonExpired = true;

    //Test purposes


    public ApplicationUser(String name, UserRole userRole) {
        this.name = name;
        this.userRole = userRole;
    }

    public ApplicationUser(String nif,
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

    public ApplicationUser(String nif, String name, String username, String email, String password, String morada, String localidade, String phone, Calendar birthday, String role) {
        this.nif = nif;
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.morada = morada;
        this.localidade = localidade;
        this.phone = phone;
        this.userRole = getRole(role);
        this.dataDeNascimento = birthday;
    }

    public String getDataDeNascimento(){
        return (dataDeNascimento.get(Calendar.DATE))+"/"+ (dataDeNascimento.get(Calendar.MONTH)+1)+"/"+ (dataDeNascimento.get(Calendar.YEAR));
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

    private String setPic(){
        switch (new Random().nextInt(4)){
            case 0:
                return "jenipurr.png";
            case 1:
                return "buffallo.png";
            case 2:
                return "capyvario.png";
            case 3:
                return  "llama.png";
            default:
                return "";
        }
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
                ", birthday=" + dataDeNascimento +
                ", userRole=" + userRole +
                ", profilePicture='" + profilePicture + '\'' +
                ", locked=" + locked +
                ", enabled=" + enabled +
                ", isAccountNonExpired=" + isAccountNonExpired +
                ", isCredentialsNonExpired=" + isCredentialsNonExpired +
                '}';
    }
}
