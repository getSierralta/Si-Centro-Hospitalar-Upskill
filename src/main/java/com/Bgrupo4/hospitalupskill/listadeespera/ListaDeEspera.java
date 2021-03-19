package com.Bgrupo4.hospitalupskill.listadeespera;

import com.Bgrupo4.hospitalupskill.user.doctor.Especialidade;
import com.Bgrupo4.hospitalupskill.user.utente.Utente;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
@Entity(name = "ListaDeEspera")
@Table(name = "listaDeEspera")
public class ListaDeEspera {

    @Id
    @SequenceGenerator(name = "listaDeEspera_sequence", sequenceName = "listaDeEspera_sequence", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "listaDeEspera_sequence")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "utente_id", nullable = false)
    @JsonManagedReference
    private Utente utente;

    @ManyToOne
    @JoinColumn(name = "especialidade_id", nullable = false)
    @JsonManagedReference
    private Especialidade especialidade;

    public ListaDeEspera(Utente utente1, Especialidade especialidade) {
        this.utente = utente1;
        this.especialidade = especialidade;
    }
}
