package com.Bgrupo4.hospitalupskill.consultas.receitas;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicamentoRepository extends JpaRepository<Medicamento, Long> {


    List<Medicamento> findAllByReceita(Long id);
}
