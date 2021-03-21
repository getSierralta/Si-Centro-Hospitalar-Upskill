package com.Bgrupo4.hospitalupskill.user.doctor.especialidade;

import com.Bgrupo4.hospitalupskill.user.doctor.especialidade.Especialidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public interface EspecialidadeRepository extends JpaRepository<Especialidade, Long> {

}
