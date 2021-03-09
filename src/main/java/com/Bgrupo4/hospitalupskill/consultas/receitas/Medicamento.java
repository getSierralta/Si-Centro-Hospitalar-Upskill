package com.Bgrupo4.hospitalupskill.consultas.receitas;

import com.Bgrupo4.hospitalupskill.consultas.Status;
import com.Bgrupo4.hospitalupskill.consultas.appointment.Appointment;
import com.Bgrupo4.hospitalupskill.user.doctor.Doctor;
import com.Bgrupo4.hospitalupskill.user.utente.Utente;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@Getter
@Setter
@Entity(name = "Medicamento")
@Table(name = "medicamento")
@NoArgsConstructor
public class Medicamento {

    @Id
    @SequenceGenerator(name = "medicamento_sequence", sequenceName = "appointment_sequence", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "appointment_sequence")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "receita_id", nullable = false)
    @JsonManagedReference
    private Receita receita;

    @Column(name= "quantidade", nullable = false)
    private String quantidade;

}
