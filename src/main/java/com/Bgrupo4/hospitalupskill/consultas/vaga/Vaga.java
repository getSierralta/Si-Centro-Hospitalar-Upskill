package com.Bgrupo4.hospitalupskill.consultas.vaga;

import com.Bgrupo4.hospitalupskill.user.doctor.Doctor;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@Entity(name = "Vaga")
@Table(name = "vaga")
public class Vaga {

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

    private boolean free = true;

    public Vaga() {
    }
}
