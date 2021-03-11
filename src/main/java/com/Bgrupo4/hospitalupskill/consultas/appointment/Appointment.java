package com.Bgrupo4.hospitalupskill.consultas.appointment;

import com.Bgrupo4.hospitalupskill.consultas.Status;
import com.Bgrupo4.hospitalupskill.user.doctor.Doctor;
import com.Bgrupo4.hospitalupskill.user.utente.Utente;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;

import java.util.Calendar;
import java.util.Date;

import static javax.persistence.GenerationType.SEQUENCE;

@Getter
@Setter
@Entity(name = "Appointment")
@Table(name = "appointment")
@NoArgsConstructor
public class Appointment{

    @Id
    @SequenceGenerator(name = "appointment_sequence", sequenceName = "appointment_sequence", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "appointment_sequence")
    private Long id;

    @Column(name= "date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar date;

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

    @Column(name= "especialidade", nullable = false)
    private String especialidade;


    public Appointment(Calendar date, Doctor doctor, Utente utente, Status status, String especialidade) {
        this.date = date;
        this.doctor = doctor;
        this.utente = utente;
        this.status = status;
        this.especialidade = especialidade;
    }

    /*
    @SneakyThrows
    @Override
    public int compareTo(Appointment o) {
        String[] oDate = o.getDate().split("-");
        String[] myDate = this.getDate().split("-");
        String[] oTime = o.getTime().split(":");
        String[] myTime = this.getTime().split(":");

        if (oDate.length != 3 || myDate.length != 3){
            throw new Exception(String.format("A data da consulta %s %s ou a data da consulta %s %s esta mal formatada", o.getId(), o.getDate(), this.getId(), this.getDate()));
        }
        if (oTime.length != 2 || myTime.length != 2){
            throw new Exception(String.format("A hora da consulta %s %s ou a data da consulta %s %s esta mal formatada", o.getId(), o.getTime(), this.getId(), this.getTime()));
        }
        if (oDate[0].equals(myDate[0]) && oDate[1].equals(myDate[1]) && oDate[2].equals(myDate[2])){
            return 0;
        }
        if (Integer.parseInt(myDate[0]) > Integer.parseInt(myDate[0])
                || (oDate[0].equals(myDate[0]) && Integer.parseInt(myDate[1]) > Integer.parseInt(myDate[1]))
                || (oDate[0].equals(myDate[0]) && myDate[1].equals(oDate[1]) && Integer.parseInt(myDate[2]) > Integer.parseInt(myDate[2]))
                || (oDate[0].equals(myDate[0]) && myDate[1].equals(oDate[1]) && myDate[2].equals(oDate[2]) && Integer.parseInt(myTime[0]) > Integer.parseInt(myTime[0]))
                || (oDate[0].equals(myDate[0]) && myDate[1].equals(oDate[1]) && myDate[2].equals(oDate[2]) && myTime[0].equals(oTime[0]) && Integer.parseInt(myTime[1]) > Integer.parseInt(myTime[1]))){
            return 1;
        }
        return -1;
    }
*/
    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", doctor=" + doctor +
                ", utente=" + utente +
                ", status=" + status +
                ", especialidade='" + especialidade + '\'' +
                '}';
    }


}
