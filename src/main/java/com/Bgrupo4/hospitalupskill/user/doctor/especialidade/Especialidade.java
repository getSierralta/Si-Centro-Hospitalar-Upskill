package com.Bgrupo4.hospitalupskill.user.doctor.especialidade;


import com.Bgrupo4.hospitalupskill.user.doctor.Doctor;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
@Entity(name = "Especialidade")
@Table(name = "especialidade")
public class Especialidade {


    @Id
    @SequenceGenerator(name = "especialidade_sequence", sequenceName = "especialidade_sequence", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "especialidade_sequence")
    private Long id;

    private String especialidade;

    @JsonBackReference
    @OneToMany(mappedBy = "especialidade",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Doctor> doctors;

    public Especialidade(String especialidade) {
        this.especialidade = especialidade;
    }

}
