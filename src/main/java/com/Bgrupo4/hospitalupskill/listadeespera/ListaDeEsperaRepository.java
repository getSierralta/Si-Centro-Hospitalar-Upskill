package com.Bgrupo4.hospitalupskill.listadeespera;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ListaDeEsperaRepository extends JpaRepository<ListaDeEspera, Long> {

}
