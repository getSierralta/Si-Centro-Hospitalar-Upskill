package com.Bgrupo4.hospitalupskill.senha;

import com.Bgrupo4.hospitalupskill.consultas.appointment.Appointment;
import com.Bgrupo4.hospitalupskill.user.doctor.Doctor;
import com.Bgrupo4.hospitalupskill.user.employee.Employee;
import com.Bgrupo4.hospitalupskill.user.utente.Utente;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name = "Senha")
@Table(name ="senha")
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@ToString
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
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Column(name= "data", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date data;

    @Column(name= "time", nullable = false)
    private String time;

    private boolean foiAtentido = false;

    private String categoria;

    private String status;

    @ManyToOne
    @JoinColumn(name = "colaborador_id")
    @JsonManagedReference
    private Employee colaborador;

}