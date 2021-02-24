package com.Bgrupo4.hospitalupskill.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Time;
import java.util.Date;

@Entity
public class Marcacao {

    @Id
    @GeneratedValue
    private Long id;
    private String utente;
    private String estado;
    private String comentario;
    private String especialidade;
    private Date data;
    private Time hora;

    public Marcacao(Date data) {
        this.data = data;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getUtente() { return utente; }

    public void setUtente(String numUtente) { this.utente = numUtente; }

    public String getEstado() { return estado; }

    public void setEstado(String estado) { this.estado = estado; }

    public String getComentario() { return comentario; }

    public void setComentario(String comentario) { this.comentario = comentario; }

    public String getEspecialidade() { return especialidade; }

    public void setEspecialidade(String especialidade) { this.especialidade = especialidade; }

    public Date getData() { return data; }

    public void setData(Date data) { this.data = data; }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }
}
