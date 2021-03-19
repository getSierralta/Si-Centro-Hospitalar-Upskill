package com.Bgrupo4.hospitalupskill.consultas.vaga;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.GregorianCalendar;
import java.util.List;

@Repository
public interface VagaRepository extends JpaRepository<Vaga, Long> {

    
    List<Vaga> findAllByDoctorId(Long id);

    List<Vaga> findAllByEspecialidade(String especialidade);


    @Query("SELECT u FROM Vaga u WHERE u.especialidade = ?1 AND u.data = ?2 AND u.free = 1")
    List<Vaga> findAllByEspecialidadeAndData(String especialidade, GregorianCalendar date);

    List<Vaga> findAllByData(GregorianCalendar time);

    Vaga findFirstByEspecialidadeAndData(String especialidade, GregorianCalendar gregorianCalendar);


}
