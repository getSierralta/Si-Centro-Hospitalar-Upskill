package com.Bgrupo4.hospitalupskill.user.employee;

import com.Bgrupo4.hospitalupskill.consultas.senha.Senha;
import com.Bgrupo4.hospitalupskill.consultas.senha.SenhaRequest;
import com.Bgrupo4.hospitalupskill.consultas.senha.SenhaService;
import lombok.AllArgsConstructor;
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

import static com.Bgrupo4.hospitalupskill.HospitalUpskillApplication.ECRA;

@Controller
@RequestMapping(path = "employee")
@AllArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;
    private final SenhaService senhaService;

    @GetMapping(value = "/profile")
    @PreAuthorize("hasRole('ROLE_COLABORADOR')")
    public String showProfile(ModelMap map) throws Exception {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Employee employee = employeeService.getLogged(auth);
        map.put("employee", employee);
        map.put("senhas", senhaService.getSenhas());
        map.put("salaDeEspera", ECRA);
        return "/employee/profile";
    }


    //GET do formulário
    @GetMapping(value = "/check-in")
    @PreAuthorize("hasRole('ROLE_COLABORADOR')")
    public String showCheckInFormulario(ModelMap map){
        map.put("categorias", senhaService.getCategorias());
        return "/employee/check-in";
    }

    //POST do formulário
    @PostMapping(path = "/check-in", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @PreAuthorize("hasRole('ROLE_COLABORADOR')")
    public RedirectView getSenha(SenhaRequest request){
        Senha senha = senhaService.createSenha(request);
        return new RedirectView("/employee/check-in/"+senha.getId());
    }

    @GetMapping(value = "/check-in/{id}")
    @PreAuthorize("hasRole('ROLE_COLABORADOR')")
    public String showSenha(@PathVariable("id") Long id, ModelMap map){
        map.put("senha", senhaService.getSenhaById(id));
        return "/employee/senha";
    }
}
