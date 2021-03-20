package com.Bgrupo4.hospitalupskill.user.employee.controllers;

import com.Bgrupo4.hospitalupskill.Calendario.EspecialidadeRequest;
import com.Bgrupo4.hospitalupskill.user.employee.Employee;
import com.Bgrupo4.hospitalupskill.user.employee.EmployeeRequest;
import com.Bgrupo4.hospitalupskill.user.employee.EmployeeService;
import com.Bgrupo4.hospitalupskill.user.employee.EmployeeUpdateRequest;
import com.Bgrupo4.hospitalupskill.user.utente.Utente;
import com.Bgrupo4.hospitalupskill.user.utente.UtenteRequest;
import com.Bgrupo4.hospitalupskill.user.utente.UtenteService;
import com.Bgrupo4.hospitalupskill.user.utente.UtenteUpdateRequest;
import com.Bgrupo4.hospitalupskill.user.utente.controllers.UtenteManagementController;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
@AllArgsConstructor
public class EmployeeRestController {

    private final EmployeeService employeeService;
    private final UtenteManagementController utenteManagementController;



    @PostMapping(path = "/calendario", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @PreAuthorize("hasRole('ROLE_COLABORADOR')")
    public RedirectView getEspecialidade(EspecialidadeRequest request){
        return new RedirectView("/employee/calendarioemployee/"+request.getEspecialidade());
    }


    @PostMapping(path = "/update", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @PreAuthorize("hasRole('ROLE_COLABORADOR')")
    public RedirectView update(EmployeeUpdateRequest request) throws Exception {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Employee employee = employeeService.getLogged(auth);
        employeeService.updateEmployee(employee, request);
        return new RedirectView("/employee/settings");
    }

    @PostMapping(path = "/uploadImage")
    @PreAuthorize("hasRole('ROLE_COLABORADOR')")
    public RedirectView updateImage(@RequestParam("imageFile") MultipartFile imageFile) throws Exception {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Employee employee = employeeService.getLogged(auth);
        try {
            employeeService.updateEmployee(employee, imageFile);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("-------------- eror saving photo");
            return new RedirectView("/500");
        }
        return new RedirectView("/employee/settings");
    }
}
