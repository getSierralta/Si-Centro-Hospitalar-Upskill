package com.Bgrupo4.hospitalupskill.user.employee;

import com.Bgrupo4.hospitalupskill.user.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public interface EmployeeRepository /*extends JpaRepository<Employee, Long> */{

}
