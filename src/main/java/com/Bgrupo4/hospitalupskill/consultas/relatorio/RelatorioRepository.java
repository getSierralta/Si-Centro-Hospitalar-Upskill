package com.Bgrupo4.hospitalupskill.consultas.relatorio;

import com.Bgrupo4.hospitalupskill.user.utente.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface RelatorioRepository extends JpaRepository<Relatorio, Long> {

    List<Relatorio> findAllByUtente(Utente utente);
}
