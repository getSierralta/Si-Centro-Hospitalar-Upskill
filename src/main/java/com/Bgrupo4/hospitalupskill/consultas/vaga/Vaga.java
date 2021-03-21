package com.Bgrupo4.hospitalupskill.consultas.vaga;

import com.Bgrupo4.hospitalupskill.user.doctor.Doctor;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.util.Calendar;

import static javax.persistence.GenerationType.SEQUENCE;

@Getter
@Setter
@Entity(name = "Vaga")
@Table(name = "vaga")
@NoArgsConstructor
@EqualsAndHashCode
public class Vaga {

    @Id
    @SequenceGenerator(name = "vaga_sequence", sequenceName = "vaga_sequence", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "vaga_sequence")
    private Long id;

    @Column(name= "date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar date;

    @Column(name= "data", nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar data;

    @Column(name= "time", nullable = false)
    private String time;


    private String especialidade;


    @ManyToOne
    @JoinColumn(name = "doctor_id")
    @JsonManagedReference
    private Doctor doctor;

    private boolean free = true;

    public Vaga(Calendar date, String time, String especialidade, Doctor doctor) {
        this.date = date;
        this.data = date;
        this.time = time;
        this.especialidade = especialidade;
        this.doctor = doctor;
    }

    @Override
    public String toString() {
        return "Vaga{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", especialidade='" + especialidade + '\'' +
                ", doctor=" + doctor.getId() +
                ", free=" + free +
                '}';
    }
    public String getDataString(){
        return (date.get(Calendar.DATE))+"/"+ (date.get(Calendar.MONTH)+1)+"/"+ (date.get(Calendar.YEAR));
    }
}
