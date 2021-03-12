package com.Bgrupo4.hospitalupskill.consultas.vaga;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@Repository
public interface VagaRepository extends JpaRepository<Vaga, Long> {

    
    List<Vaga> findAllByDoctorId(Long id);

    List<Vaga> findAllByEspecialidade(String especialidade);


    @Query("SELECT u FROM Vaga u WHERE u.especialidade = ?1 AND u.date = ?2 AND u.free = 1")
    List<Vaga> findAllByEspecialidadeAndDate(String especialidade, GregorianCalendar date);


    List<Vaga> findAllByDate(GregorianCalendar time);

    Vaga findFirstByEspecialidadeAndDate(String especialidade, GregorianCalendar gregorianCalendar);
}
