package com.Bgrupo4.hospitalupskill.user.employee;

import com.Bgrupo4.hospitalupskill.user.User;
import com.Bgrupo4.hospitalupskill.user.UserRole;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.sql.Date;
import java.util.ArrayList;

public class Employee extends User {

    @Id
    private int numFuncionario;
    private Hospital unidade;
    private ArrayList<EmployeeRole> cargos = new ArrayList<>();
    @Enumerated(EnumType.STRING)
    private UserRole userRole = UserRole.COLABORADOR;

    public Employee(Integer utente,
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
                    EmployeeRole cargo1,
                    EmployeeRole cargo2) {
        super(utente, name, username, email, password, morada, localidade, phone, birthday, userRole);
        this.numFuncionario = numFuncionario;
        this.unidade = unidade;
        cargos.add(cargo1);
        if(cargo2 != null){cargos.add(cargo2);}
    }

    public int getNumFuncionario() {
        return numFuncionario;
    }

    public void setNumFuncionario(int numFuncionario) {
        this.numFuncionario = numFuncionario;
    }

    public Hospital getUnidade() {
        return unidade;
    }

    public void setUnidade(Hospital unidade) {
        this.unidade = unidade;
    }

    public ArrayList<EmployeeRole> getCargos() {
        return cargos;
    }

    public void setCargos(ArrayList<EmployeeRole> cargos) {
        this.cargos = cargos;
    }
}
