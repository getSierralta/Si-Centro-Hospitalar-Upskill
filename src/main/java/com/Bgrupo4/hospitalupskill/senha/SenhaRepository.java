package com.Bgrupo4.hospitalupskill.senha;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SenhaRepository extends JpaRepository<Senha, Long> {
}
