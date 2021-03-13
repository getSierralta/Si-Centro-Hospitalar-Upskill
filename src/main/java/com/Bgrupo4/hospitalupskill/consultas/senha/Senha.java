package com.Bgrupo4.hospitalupskill.consultas.senha;

import com.Bgrupo4.hospitalupskill.consultas.appointment.Appointment;
import com.Bgrupo4.hospitalupskill.user.doctor.Doctor;
import com.Bgrupo4.hospitalupskill.user.utente.Utente;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.Date;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name = "Senha")
@Table(name ="senha")
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Senha {

    public static int contadorA = 0;
    public static int contaborB = 0;
    public static int contadorC = 0;

    @Id
    @SequenceGenerator(name = "senha_sequence", sequenceName = "senha_sequence", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "senha_sequence")
    private Long id;

    private String numeroSenha;

    @ManyToOne
    @JoinColumn(name = "utente_id", nullable = false)
    @JsonManagedReference
    private Utente utente;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    @JsonManagedReference
    private Doctor doctor;

    @OneToOne
    private Appointment appointment;

    @Column(name= "date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(name= "time", nullable = false)
    private String time;

    private boolean foiAtentido = false;


    public Senha(String numeroSenha, Utente utente, Doctor doctor, Appointment appointment, Date date, String time) {
        this.numeroSenha = numeroSenha;
        this.utente = utente;
        this.doctor = doctor;
        this.appointment = appointment;
        this.date = date;
        this.time = time;
    }

    @Override
    public String toString() {
        return "Senha{" +
                "id=" + id +
                ", numeroSenha='" + numeroSenha + '\'' +
                ", utente=" + utente +
                ", doctor=" + doctor +
                ", appointment=" + appointment +
                ", date='" + date + '\'' +
                '}';
    }
}