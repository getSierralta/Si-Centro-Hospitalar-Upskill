package com.Bgrupo4.hospitalupskill.consultas.receitas;


import com.Bgrupo4.hospitalupskill.consultas.appointment.Appointment;
import com.Bgrupo4.hospitalupskill.user.doctor.Doctor;
import com.Bgrupo4.hospitalupskill.user.utente.Utente;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@Getter
@Setter
@Entity(name = "Receita")
@Table(name = "receita")
@NoArgsConstructor
@ToString
public class Receita implements Comparable<Receita>{

    @Id
    @SequenceGenerator(name = "receita_sequence", sequenceName = "receita_sequence", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "receita_sequence")
    private Long id;

    @Column(name= "date", nullable = false)
    private String date;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    @JsonManagedReference
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "utente_id", nullable = false)
    @JsonManagedReference
    private Utente utente;

    @ManyToOne
    @JoinColumn(name = "appointment_id", nullable = false)
    @JsonManagedReference
    private Appointment appointment;

    @JsonBackReference
    @OneToMany(mappedBy = "receita", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Medicamento> medicamentos;

    @Column(name= "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private ReceitaStatus status = ReceitaStatus.OPEN;

    public Receita(String date, Doctor doctor, Utente utente, Appointment appointment, List<Medicamento> medicamentos) {
        this.date = date;
        this.doctor = doctor;
        this.utente = utente;
        this.appointment = appointment;
        this.medicamentos = medicamentos;
    }

    @SneakyThrows
    @Override
    public int compareTo(Receita o) {
        String[] oDate = o.getDate().split("-");
        String[] myDate = this.getDate().split("-");
        if (oDate.length != 3 || myDate.length != 3){
            throw new Exception(String.format("A data da consulta %s %s ou a data da consulta %s %s esta mal formatada", o.getId(), o.getDate(), this.getId(), this.getDate()));
        }
        if (oDate[0].equals(myDate[0]) && oDate[1].equals(myDate[1]) && oDate[2].equals(myDate[2])){
            return 0;
        }
        if (Integer.parseInt(myDate[0]) < Integer.parseInt(myDate[0])
                || (oDate[0].equals(myDate[0]) && Integer.parseInt(myDate[1]) < Integer.parseInt(myDate[1]))
                || (oDate[0].equals(myDate[0]) && myDate[1].equals(oDate[1]) && Integer.parseInt(myDate[2]) < Integer.parseInt(myDate[2]))){
            return 1;
        }
        return -1;
    }
}
