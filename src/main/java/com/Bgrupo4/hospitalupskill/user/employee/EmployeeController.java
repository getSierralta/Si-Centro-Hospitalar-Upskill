package com.Bgrupo4.hospitalupskill.user.employee;

import com.Bgrupo4.hospitalupskill.consultas.ConsultasService;
import com.Bgrupo4.hospitalupskill.consultas.appointment.Appointment;
import com.Bgrupo4.hospitalupskill.senha.SenhaRequest;
import com.Bgrupo4.hospitalupskill.senha.SenhaService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping(path = "employee")
@AllArgsConstructor
public class EmployeeController {

    private final ConsultasService consultasService;
    private final EmployeeService employeeService;
    private final Appointment appointment;
    private final SenhaService senhaService;

    @GetMapping(value = "/profile")
    public String showProfile(ModelMap map) throws Exception {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Employee employee = employeeService.getLogged(auth);
        map.put("employee", employee);
        return "/employee/profile";
    }

    /*@GetMapping(value = "/check-in")
    public String showCheckIn(ModelMap map) throws Exception {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Employee employee = employeeService.getLogged(auth);
        map.put("employee", employee);
        return "/employee/check-in";
    }*/

    //GET do formulário
    @GetMapping(value = "/check-in")
    @PreAuthorize("hasRole('ROLE_COLABORADOR')")
    public String showCheckInFormulario(ModelMap map){
        map.put("appointment", consultasService.getAppointment(appointment.getId()));
        return "/employee/checkin";
    }

    //POST do formulário
    @PostMapping(path = "/check-in", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @PreAuthorize("hasRole('ROLE_COLABORADOR')")
    public RedirectView getSenha(SenhaRequest request){
        return new RedirectView("/employee/check-in/"+ senhaService.createSenha(request));
    }
}
