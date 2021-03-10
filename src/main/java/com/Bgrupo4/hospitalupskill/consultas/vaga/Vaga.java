package com.Bgrupo4.hospitalupskill.consultas.vaga;

import com.Bgrupo4.hospitalupskill.user.doctor.Doctor;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

import static javax.persistence.GenerationType.SEQUENCE;

@Getter
@Setter
@Entity(name = "Vaga")
@Table(name = "vaga")
@NoArgsConstructor
public class Vaga {

    @Id
    @SequenceGenerator(name = "vaga_sequence", sequenceName = "vaga_sequence", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "vaga_sequence")
    private Long id;

    @Column(name= "date", nullable = false)
    private String date;

    @Column(name= "time", nullable = false)
    private String time;

    @Column(name= "especialidade", nullable = false)
    private String especialidade;


    @ManyToOne
    @JoinColumn(name = "doctor_id")
    @JsonManagedReference
    private Doctor doctor;

    private boolean free = true;

    public Vaga(String date, String time, String especialidade, Doctor doctor) {
        this.date = date;
        this.time = time;
        this.especialidade = especialidade;
        this.doctor = doctor;
    }

    @Override
    public String toString() {
        return "Vaga{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", especialidade='" + especialidade + '\'' +
                ", doctor=" + doctor +
                ", free=" + free +
                '}';
    }
}
