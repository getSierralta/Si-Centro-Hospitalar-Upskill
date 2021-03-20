package com.Bgrupo4.hospitalupskill.user.employee;

import lombok.Data;

@Data
public class EmployeeUpdateRequest {
    private final String name;
    private final String morada;
    private final String localidade;
    private final String telemovel;
    private final String password;
}
