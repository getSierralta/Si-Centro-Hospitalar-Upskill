package com.Bgrupo4.hospitalupskill.user.employee;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeService {
    private final static String USER_NOT_FOUND_MSG = "O colaborador %s não foi encontrado";

    private final EmployeeRepository employeeRepository;

}
