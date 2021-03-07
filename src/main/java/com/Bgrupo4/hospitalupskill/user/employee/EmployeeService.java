package com.Bgrupo4.hospitalupskill.user.employee;

import com.Bgrupo4.hospitalupskill.user.ApplicationUserService;
import com.Bgrupo4.hospitalupskill.user.doctor.Doctor;
import com.Bgrupo4.hospitalupskill.user.doctor.DoctorRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeService {
    private final static String USER_NOT_FOUND_MSG = "O colaborador %s não foi encontrado";

    private final EmployeeRepository employeeRepository;
    private final ApplicationUserService applicationUserService;

    public Optional<Employee> getUserById(Long id) {
        return employeeRepository.findById(id);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    public void registerEmployee(Employee employee) {
        applicationUserService.enableAndSave(employee);
    }

    public Employee updateEmployee(Long id, EmployeeRequest request) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (!employee.isPresent()) {
            throw new EntityNotFoundException(String.format("Colaborador %s não foi encontrado", id));
        }
        Employee employee1 = employee.get();
        employee1.setMorada(request.getMorada());
        return employeeRepository.save(employee1);
    }
}
