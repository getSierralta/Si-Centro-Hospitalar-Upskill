package com.Bgrupo4.hospitalupskill.user.employee;

import com.Bgrupo4.hospitalupskill.user.User;
import com.Bgrupo4.hospitalupskill.user.UserRole;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;
import java.util.ArrayList;

@Getter
@Setter
@Entity
public class Employee extends User {

    @Id
    private int numFuncionario;
    private Hospital unidade;
    private ArrayList<EmployeeRole> cargos = new ArrayList<>();

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
}
