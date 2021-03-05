package com.Bgrupo4.hospitalupskill.user.doctor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface DoctorRepository  extends JpaRepository<Doctor, Long> {

    @Transactional
    @Modifying
    @Query("UPDATE Doctor a SET a.enabled = TRUE WHERE a.email = ?1")
    int enableUser(String email);

    Optional<Doctor> findByUsername(String username);
}
