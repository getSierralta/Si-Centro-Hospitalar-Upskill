package com.Bgrupo4.hospitalupskill.user.employee.doctor;

import com.Bgrupo4.hospitalupskill.user.employee.Employee;
import com.Bgrupo4.hospitalupskill.user.employee.EmployeeRole;
import com.Bgrupo4.hospitalupskill.user.employee.Hospital;
import com.Bgrupo4.hospitalupskill.user.User;
import com.Bgrupo4.hospitalupskill.user.UserRole;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.sql.Date;
import java.util.ArrayList;

public class Doctor extends Employee {

    @Id
    private String cedula;
    private ArrayList<Especialidade> especialidades = new ArrayList<>();
    @Enumerated(EnumType.STRING)
    private UserRole userRole = UserRole.MEDICO;

    public Doctor(Integer utente,
                  String name,
                  String username,
                  String email,
                  String password,
                  String morada,
                  String localidade,
                  String phone,
                  Date birthday,
                  UserRole userRole,
                  int numFuncionario,
                  Hospital unidade,
                  String cedula,
                  EmployeeRole cargo1,
                  EmployeeRole cargo2,
                  Especialidade esp1,
                  Especialidade esp2,
                  Especialidade esp3,
                  Especialidade esp4,
                  Especialidade esp5) {
        super(utente, name, username, email, password, morada, localidade, phone, birthday, userRole, numFuncionario, unidade, cargo1, cargo2);
        this.cedula = cedula;
        especialidades.add(esp1);
        if(esp2 != null){especialidades.add(esp2);}
        if(esp3 != null){especialidades.add(esp3);}
        if(esp4 != null){especialidades.add(esp4);}
        if(esp5 != null){especialidades.add(esp5);}
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public ArrayList<Especialidade> getEspecialidades() {
        return especialidades;
    }

    public void setEspecialidades(ArrayList<Especialidade> especialidades) {
        this.especialidades = especialidades;
    }
}


