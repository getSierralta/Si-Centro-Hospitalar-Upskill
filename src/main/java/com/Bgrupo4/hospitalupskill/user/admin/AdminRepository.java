package com.Bgrupo4.hospitalupskill.user.admin;

import com.Bgrupo4.hospitalupskill.user.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface AdminRepository extends JpaRepository<Admin, Long>{

    @Transactional
    @Modifying
    @Query("UPDATE Admin a SET a.enabled = TRUE WHERE a.email = ?1")
    int enableUser(String email);

    Optional<Admin> findByUsername(String username);
}
