package com.Bgrupo4.hospitalupskill.user.doctor;


import com.Bgrupo4.hospitalupskill.consultas.appointment.Appointment;
import com.Bgrupo4.hospitalupskill.consultas.vaga.Vaga;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
@Entity(name = "Especialidade")
@Table(name = "especialidade", uniqueConstraints = {@UniqueConstraint(name = "especialidade_unique", columnNames = "especialidade")})
public class Especialidade {

    @Id
    @SequenceGenerator(name = "appointment_sequence", sequenceName = "appointment_sequence", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "appointment_sequence")
    private Long id;

    private String especialidade;

    @JsonBackReference
    @OneToMany(mappedBy = "especialidade",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Doctor> doctors;

    @JsonBackReference
    @OneToMany(mappedBy = "especialidade",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Vaga> vagas;

    @JsonBackReference
    @OneToMany(mappedBy = "especialidade",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Appointment> appointments;

    public Especialidade(String especialidade) {
        this.especialidade = especialidade;
    }
}
