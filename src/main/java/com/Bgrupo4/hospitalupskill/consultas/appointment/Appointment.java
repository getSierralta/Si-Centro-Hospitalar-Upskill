package com.Bgrupo4.hospitalupskill.consultas.appointment;

import com.Bgrupo4.hospitalupskill.consultas.Status;
import com.Bgrupo4.hospitalupskill.user.doctor.Doctor;
import com.Bgrupo4.hospitalupskill.user.utente.Utente;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

@Getter
@Setter
@Entity(name = "Appointment")
@Table(name = "appointment")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name= "date", nullable = false)
    private LocalDate date;

    @Column(name= "time", nullable = false)
    private LocalTime time;


    @ManyToOne
    @JoinColumn(name = "doctor_id")
    @JsonManagedReference
    private Doctor doctor;


    @ManyToOne
    @JoinColumn(name = "utente_id")
    @JsonManagedReference
    private Utente utente;

    @Column(name= "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;



    public Appointment() {
    }

}
