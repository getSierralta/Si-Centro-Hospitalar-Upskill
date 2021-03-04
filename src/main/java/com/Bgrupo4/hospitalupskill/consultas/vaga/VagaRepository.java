package com.Bgrupo4.hospitalupskill.consultas.vaga;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VagaRepository extends JpaRepository<Vaga, Long> {

    //todo
    //List<Vaga> findAllByEspecialidade(String especialidade);

    List<Vaga> findAllByDoctorId(Long id);
}
