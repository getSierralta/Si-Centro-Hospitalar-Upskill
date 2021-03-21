package com.Bgrupo4.hospitalupskill.user.employee;

import com.Bgrupo4.hospitalupskill.user.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

    @Transactional
    @Modifying
    @Query("UPDATE Employee a SET a.enabled = TRUE WHERE a.email = ?1")
    int enableUser(String email);

    Optional<Employee> findByUsername(String username);

    Employee findByNif(String nif);
}
