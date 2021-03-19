package com.Bgrupo4.hospitalupskill.user.employee.controllers;

import com.Bgrupo4.hospitalupskill.Calendario.CalendarioService;
import com.Bgrupo4.hospitalupskill.invoices.InvoiceController;
import com.Bgrupo4.hospitalupskill.invoices.InvoiceRequest;
import com.Bgrupo4.hospitalupskill.senha.Senha;
import com.Bgrupo4.hospitalupskill.senha.SenhaRequest;
import com.Bgrupo4.hospitalupskill.senha.SenhaService;
import com.Bgrupo4.hospitalupskill.user.employee.Employee;
import com.Bgrupo4.hospitalupskill.user.employee.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
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

    //GET do invoice
    @GetMapping(value = "/payments")
    @PreAuthorize("hasAnyRole('ROLE_COLABORADOR', 'ROLE_ADMIN', 'ROLE_RESPONSAVEL')")
    public String showBills(ModelMap map, @RequestParam (required = false) String search, @RequestParam (required = false) String status){
        map.put("invoiceList", invoiceController.getList(search, status));
        return "/employee/payments";
    }

    @GetMapping(value = "/new-bill")
    @PreAuthorize("hasAnyRole('ROLE_COLABORADOR', 'ROLE_ADMIN', 'ROLE_RESPONSAVEL')")
    public String createBill(){
        return "/employee/new-bill";
    }

    @GetMapping(value = "/success")
    @PreAuthorize("hasAnyRole('ROLE_COLABORADOR', 'ROLE_ADMIN', 'ROLE_RESPONSAVEL')")
    public String showSuccess() {
        return "/employee/success";
    }

    @GetMapping(value = "/error")
    @PreAuthorize("hasAnyRole('ROLE_COLABORADOR', 'ROLE_ADMIN', 'ROLE_RESPONSAVEL')")
    public String showError() {
        return "/employee/error";
    }

/*
    @RequestMapping(method = RequestMethod.GET, value = "/utente-bills/{id}")
    @PreAuthorize("hasAnyRole('ROLE_COLABORADOR', 'ROLE_ADMIN', 'ROLE_RESPONSAVEL')")
    public ModelAndView getBill(@RequestParam String id){
        InvoiceRequest invoiceRequest = new InvoiceRequest();
        invoiceRequest.setId(id);
        System.out.println("EC: " + id);
        return invoiceController.getInvoice(invoiceRequest);
    }*/
}
