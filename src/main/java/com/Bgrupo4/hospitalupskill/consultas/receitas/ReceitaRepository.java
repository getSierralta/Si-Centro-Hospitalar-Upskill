package com.Bgrupo4.hospitalupskill.consultas.receitas;

import com.Bgrupo4.hospitalupskill.user.utente.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReceitaRepository extends JpaRepository<Receita, Long> {


    List<Receita> findAllByUtenteId(Long id);

    List<Receita> findAllByUtenteOrderByDateAsc(Utente utente);
}
