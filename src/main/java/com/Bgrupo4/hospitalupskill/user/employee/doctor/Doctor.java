package com.Bgrupo4.hospitalupskill.user.employee.doctor;

import com.Bgrupo4.hospitalupskill.user.employee.Employee;
import com.Bgrupo4.hospitalupskill.user.employee.Unidade;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Doctor extends Employee {


    private String cedula;
    private List<Especialidade> especialidades;

    public Doctor(Integer nif, String name, String username, String email, String password, String role, Unidade unidade, String cedula, List<Especialidade> especialidades) {
        super(nif, name, username, email, password, role, unidade);
        this.cedula = cedula;
        this.especialidades = especialidades;
    }
}


