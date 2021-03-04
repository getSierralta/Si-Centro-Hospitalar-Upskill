package com.Bgrupo4.hospitalupskill.user.employee.doctor;

import com.Bgrupo4.hospitalupskill.user.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public interface DoctorRepository/* extends JpaRepository<Doctor, Long>*/ {

}
