package com.Bgrupo4.hospitalupskill.consultas.appointment;

import com.Bgrupo4.hospitalupskill.consultas.Status;
import com.Bgrupo4.hospitalupskill.user.doctor.Doctor;
import com.Bgrupo4.hospitalupskill.user.utente.Utente;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;

import java.util.Calendar;

import static javax.persistence.GenerationType.SEQUENCE;

@Getter
@Setter
@Entity(name = "Appointment")
@Table(name = "appointment")
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Appointment{

    @Id
    @SequenceGenerator(name = "appointment_sequence", sequenceName = "appointment_sequence", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "appointment_sequence")
    private Long id;

    @Column(name= "date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar date;

    @Column(name= "data", nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar data;

    @Column(name= "time", nullable = false)
    private String time;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    @JsonManagedReference
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "utente_id", nullable = false)
    @JsonManagedReference
    private Utente utente;

    @Column(name= "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status = Status.OPEN;


    private String especialidade;


    @Column(name= "startedAt")
    private String startedAt;


    public Appointment(Calendar date, Doctor doctor, Utente utente, Status status, String especialidade) {
        this.date = date;
        this.data = date;
        this.doctor = doctor;
        this.utente = utente;
        this.status = status;
        this.especialidade = especialidade;
    }

    public String getDataString(){
        return (date.get(Calendar.DATE))+"/"+ (date.get(Calendar.MONTH)+1)+"/"+ (date.get(Calendar.YEAR));
    }





}
