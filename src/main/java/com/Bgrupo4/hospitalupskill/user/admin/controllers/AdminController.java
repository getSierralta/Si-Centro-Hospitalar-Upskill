package com.Bgrupo4.hospitalupskill.user.admin.controllers;


import com.Bgrupo4.hospitalupskill.calendario.CalendarioService;
import com.Bgrupo4.hospitalupskill.user.admin.Admin;
import com.Bgrupo4.hospitalupskill.user.admin.AdminService;
import com.Bgrupo4.hospitalupskill.user.doctor.Doctor;
import com.Bgrupo4.hospitalupskill.user.doctor.DoctorService;
import com.Bgrupo4.hospitalupskill.user.doctor.controllers.DoctorManagementController;
import com.Bgrupo4.hospitalupskill.user.employee.Employee;
import com.Bgrupo4.hospitalupskill.user.employee.EmployeeService;
import com.Bgrupo4.hospitalupskill.user.employee.controllers.EmployeeManagementController;
import com.Bgrupo4.hospitalupskill.user.employee.controllers.EmployeeRestController;
import com.Bgrupo4.hospitalupskill.user.utente.Utente;
import com.Bgrupo4.hospitalupskill.user.utente.UtenteService;
import com.Bgrupo4.hospitalupskill.user.utente.controllers.UtenteManagementController;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final DoctorManagementController doctorManagementController;
    private final UtenteManagementController utenteManagementController;
    private final AdminManagementController adminManagementController;
    private final EmployeeManagementController employeeManagementController;
    private final UtenteService utenteService;
    private final EmployeeService employeeService;
    private final DoctorService doctorService;

    @Autowired
    AdminService adminService;

    @Autowired
    CalendarioService calendarioService;

    @GetMapping(value = "/profile")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String showProfile(ModelMap map){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        try {
            map.put("admin", adminService.getLogged(auth));
            map.put("especialidades", calendarioService.getEspecialidades());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/admin/profile";
    }

    @GetMapping(value = "/lista-utentes")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String showUtentes(ModelMap map) {
        map.put("utenteList", utenteManagementController.getAllUtentes());
        return "/admin/lista-utentes";
    }

    @GetMapping(value = "/lista-utentes/espera")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String showUtentesEspera(ModelMap map) {
        map.put("utenteList", utenteService.getAllUtentesAEspera());
        return "/admin/lista-utentes";
    }

    @GetMapping(value = "/lista-utentes/atrasados")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String showUtentesAtrasados(ModelMap map) {
        map.put("utenteList", utenteService.getAllUtentesAtrasados());
        return "/admin/lista-utentes";
    }

    @GetMapping(value = "/lista-utentes/atendidos")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String showUtentesAtendidos(ModelMap map) {
        map.put("utenteList", utenteService.getAllUtentesAtendidos());
        return "/admin/lista-utentes";
    }

    @GetMapping(value = "/lista-utentes/username/{username}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String showUtente(ModelMap map, @PathVariable String username) {
        try {
            List<Utente> utentes = new ArrayList<>();
            utentes.add(utenteService.getUserByUsername(username).get());
            map.put("utenteList", utentes);
        }catch (Exception e){
            map.put("utenteList", utenteManagementController.getAllUtentes());
        }
        return "/admin/lista-utentes";
    }
    @GetMapping(value = "/lista-utentes/nif/{nif}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String showUtenteNif(ModelMap map, @PathVariable String nif) {
        try {
            List<Utente> utentes = new ArrayList<>();
            utentes.add(utenteService.getUserByNif(nif));
            map.put("utenteList", utentes);
            return "/admin/lista-utentes";
        }catch (Exception e){
            map.put("utenteList", utenteManagementController.getAllUtentes());
            return "/admin/lista-utentes";
        }
    }


    @GetMapping(value = "/lista-medicos")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String showDoctors(ModelMap map) {
        map.put("especialidades", calendarioService.getEspecialidades());
        map.put("doctorList", doctorManagementController.getAllDoctors());
        return "/admin/lista-medicos";
    }

    @GetMapping(value = "/lista-medicos/username/{username}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String showDoctor(ModelMap map, @PathVariable String username) {
        map.put("especialidades", calendarioService.getEspecialidades());
        try {
            List<Doctor> doctors = new ArrayList<>();
            doctors.add(doctorService.getUserByUsername(username).get());
            map.put("doctorList", doctors);
            return "/admin/lista-medicos";
        }catch (Exception e){
            map.put("doctorList", doctorManagementController.getAllDoctors());
            return "/admin/lista-medicos";
        }
    }
    @GetMapping(value = "/lista-medicos/nif/{nif}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String showDoctorNif(ModelMap map, @PathVariable String nif) {
        map.put("especialidades", calendarioService.getEspecialidades());
        try {
            List<Doctor> doctors = new ArrayList<>();
            doctors.add(doctorService.getDoctorByNif(nif));
            map.put("doctorList", doctors);
            return "/admin/lista-medicos";
        }catch (Exception e){
            map.put("doctorList", doctorManagementController.getAllDoctors());
            return "/admin/lista-medicos";
        }
    }

    @GetMapping(value = "/lista-medicos/especialidade/{especialidade}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String showDoctorEspecialidade(ModelMap map, @PathVariable String especialidade) {
        map.put("especialidades", calendarioService.getEspecialidades());
        map.put("doctorList", doctorService.getDoctorByEspecialidade(especialidade));
        return "/admin/lista-medicos";
    }

    @GetMapping(value = "/lista-employees")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String showEmployees(ModelMap map) {
        map.put("employeeList", employeeManagementController.getAllEmployees());
        return "/admin/lista-employees";
    }

    @GetMapping(value = "/lista-employees/username/{username}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String showEmployee(ModelMap map, @PathVariable String username) {
        try {
            List<Employee> employees = new ArrayList<>();
            employees.add(employeeService.getUserByUsername(username).get());
            map.put("employeeList", employees);
            return "/admin/lista-employees";
        }catch (Exception e){
            map.put("employeeList", employeeManagementController.getAllEmployees());
            return "/admin/lista-employees";
        }
    }
    @GetMapping(value = "/lista-employees/nif/{nif}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String showEmployeeNif(ModelMap map, @PathVariable String nif) {
        try {
            List<Employee> employees = new ArrayList<>();
            employees.add(employeeService.getEmployeeByNif(nif));
            map.put("employeeList", employees);
            return "/admin/lista-employees";
        }catch (Exception e){
            map.put("employeeList", employeeManagementController.getAllEmployees());
            return "/admin/lista-employees";
        }
    }

    @GetMapping(value = "/lista-admin")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String showAdmins(ModelMap map) {
        map.put("adminList", adminManagementController.getAllAdmin());
        return "/admin/lista-admin";
    }

    @GetMapping(value = "/lista-admin/username/{username}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String showAdmin(ModelMap map, @PathVariable String username) {
        try {
            List<Admin> admins = new ArrayList<>();
            admins.add(adminService.getUserByUsername(username).get());
            map.put("adminList", admins);
            return "/admin/lista-admin";
        }catch (Exception e){
            map.put("adminList", adminManagementController.getAllAdmin());
            return "/admin/lista-admin";
        }
    }
    @GetMapping(value = "/lista-admin/nif/{nif}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String showAdminNif(ModelMap map, @PathVariable String nif) {
        try {
            List<Admin> admins = new ArrayList<>();
            admins.add(adminService.getAdminByNif(nif));
            map.put("adminList", admins);
            return "/admin/lista-admin";
        }catch (Exception e){
            map.put("adminList", adminManagementController.getAllAdmin());
            return "/admin/lista-admin";
        }
    }

    @GetMapping(value = "/settings")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String showSettings(ModelMap map){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        try {
            map.put("admin", adminService.getLogged(auth));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/admin/settings";
    }

    @GetMapping(value = "/register-employee")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String showRegisterEmployee() {
        return "/admin/register-employee";
    }

    @GetMapping(value = "/register-doctor")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String showRegisterDoctor(ModelMap map) {
        map.put("especialidades", calendarioService.getEspecialidades());
        return "/admin/register-doctor";
    }

    @GetMapping(value = "/register-success")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String showRegisterSuccess() {
        return "/admin/register-success";
    }

}