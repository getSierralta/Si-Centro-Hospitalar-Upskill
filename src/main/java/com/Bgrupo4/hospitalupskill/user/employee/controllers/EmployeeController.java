package com.Bgrupo4.hospitalupskill.user.employee.controllers;

import com.Bgrupo4.hospitalupskill.Calendario.CalendarioService;
import com.Bgrupo4.hospitalupskill.invoices.InvoiceController;
import com.Bgrupo4.hospitalupskill.senha.Senha;
import com.Bgrupo4.hospitalupskill.senha.SenhaRequest;
import com.Bgrupo4.hospitalupskill.senha.SenhaService;
import com.Bgrupo4.hospitalupskill.user.employee.Employee;
import com.Bgrupo4.hospitalupskill.user.employee.EmployeeService;
import com.Bgrupo4.hospitalupskill.user.employee.EmployeeUpdateRequest;
import com.Bgrupo4.hospitalupskill.user.utente.Utente;
import com.Bgrupo4.hospitalupskill.user.utente.UtenteUpdateRequest;
import com.Bgrupo4.hospitalupskill.user.utente.controllers.UtenteManagementController;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import static com.Bgrupo4.hospitalupskill.HospitalUpskillApplication.ECRA;

@Controller
@RequestMapping(path = "employee")
@AllArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;
    private final SenhaService senhaService;
    private final CalendarioService calendarioService;
    private final InvoiceController invoiceController;
    private final UtenteManagementController utenteManagementController;

    @GetMapping(value = "/show-all-utentes")
    public String showUtentes(ModelMap map) {
        map.put("utenteList", utenteManagementController.getAllUtentes());
        return "/employee/show-all-utentes";
    }

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

    @GetMapping(value = "/utente-bills")
    @PreAuthorize("hasAnyRole('ROLE_COLABORADOR', 'ROLE_ADMIN', 'ROLE_RESPONSAVEL')")
    public String showBills(ModelMap map){
        map.put("invoiceList", invoiceController.getList());
        return "/employee/utente-bills";
    }

    @GetMapping(value = "/new-bill")
    @PreAuthorize("hasAnyRole('ROLE_COLABORADOR', 'ROLE_ADMIN', 'ROLE_RESPONSAVEL')")
    public String createBills(ModelMap map){
        map.put("categorias", senhaService.getCategorias());
        return "/employee/new-bill";
    }

    @GetMapping(value = "/formularioCalendario")
    @PreAuthorize("hasRole('ROLE_COLABORADOR')")
    public String showFormularioCalendario(ModelMap map){
        map.put("especialidades", calendarioService.getEspecialidades());
        return "employee/formularioCalendario";
    }

    @GetMapping(value = "/calendarioemployee/{especialidade}")
    @PreAuthorize("hasRole('ROLE_COLABORADOR')")
    public String showCalendarioGeral(@PathVariable String especialidade){
        return "employee/calendarioemployee";
    }

    @GetMapping(value = "/settings")
    @PreAuthorize("hasRole('ROLE_COLABORADOR')")
    public String showSetting(ModelMap map) throws Exception {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Employee employee = employeeService.getLogged(auth);
        map.put("employee", employee);
        return "employee/settings";
    }

}
