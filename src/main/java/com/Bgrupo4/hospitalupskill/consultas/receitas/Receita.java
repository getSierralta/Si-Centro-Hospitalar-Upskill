package com.Bgrupo4.hospitalupskill.consultas.receitas;


import com.Bgrupo4.hospitalupskill.consultas.appointment.Appointment;
import com.Bgrupo4.hospitalupskill.user.doctor.Doctor;
import com.Bgrupo4.hospitalupskill.user.utente.Utente;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@Getter
@Setter
@Entity(name = "Receita")
@Table(name = "receita")
@NoArgsConstructor
@ToString
public class Receita{

    @Id
    @SequenceGenerator(name = "receita_sequence", sequenceName = "receita_sequence", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "receita_sequence")
    private Long id;

    @Column(name= "date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date date;

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

    public Receita(Date date, Doctor doctor, Utente utente, Appointment appointment, List<Medicamento> medicamentos) {
        this.date = date;
        this.doctor = doctor;
        this.utente = utente;
        this.appointment = appointment;
        this.medicamentos = medicamentos;
    }


}
