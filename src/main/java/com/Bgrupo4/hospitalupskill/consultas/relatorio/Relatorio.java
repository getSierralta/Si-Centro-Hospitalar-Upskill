package com.Bgrupo4.hospitalupskill.consultas.relatorio;

import com.Bgrupo4.hospitalupskill.user.doctor.Doctor;
import com.Bgrupo4.hospitalupskill.user.utente.Utente;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.GenerationType.SEQUENCE;

@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
@Entity(name = "Relatorio")
@Table(name = "relatorio")
public class Relatorio {
    @Id
    @SequenceGenerator(name = "relatorio_sequence", sequenceName = "relatorio_sequence", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "relatorio_sequence")
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

    @Column(length = 2400)
    private String description;
}
