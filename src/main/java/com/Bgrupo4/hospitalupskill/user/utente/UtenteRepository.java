package com.Bgrupo4.hospitalupskill.user.utente;


import com.Bgrupo4.hospitalupskill.user.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface UtenteRepository extends JpaRepository<Utente, Long> {

    Optional<Utente> findByUsername(String username);

    @Transactional
    @Modifying
    @Query("UPDATE Utente a SET a.enabled = TRUE WHERE a.email = ?1")
    int enableUser(String email);
}
