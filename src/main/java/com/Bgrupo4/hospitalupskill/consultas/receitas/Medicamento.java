package com.Bgrupo4.hospitalupskill.consultas.receitas;

import com.Bgrupo4.hospitalupskill.user.utente.Utente;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Getter
@Setter
@Entity(name = "Medicamento")
@Table(name = "medicamento")
@NoArgsConstructor
@ToString
public class Medicamento {

    @Id
    @SequenceGenerator(name = "medicamento_sequence", sequenceName = "medicamento_sequence", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "medicamento_sequence")
    private Long id;

    @Column(name= "quantidade", nullable = false)
    private String quantidade;

    @Column(name= "medicamento", nullable = false)
    private String medicamento;

    @ManyToOne
    @JoinColumn(name = "receita_id", nullable = false)
    @JsonManagedReference
    private Receita receita;

    @ManyToOne
    @JoinColumn(name = "utente_id", nullable = false)
    @JsonManagedReference
    private Utente utente;



    public Medicamento(String medicamento, String quantidade) {
        this.quantidade = quantidade;
        this.medicamento = medicamento;
    }
}
