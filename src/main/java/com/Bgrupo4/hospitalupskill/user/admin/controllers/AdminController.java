package com.Bgrupo4.hospitalupskill.user.admin.controllers;


import com.Bgrupo4.hospitalupskill.calendario.CalendarioService;
import com.Bgrupo4.hospitalupskill.user.admin.AdminService;
import com.Bgrupo4.hospitalupskill.user.doctor.controllers.DoctorManagementController;
import com.Bgrupo4.hospitalupskill.user.employee.controllers.EmployeeManagementController;
import com.Bgrupo4.hospitalupskill.user.employee.controllers.EmployeeRestController;
import com.Bgrupo4.hospitalupskill.user.utente.controllers.UtenteManagementController;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final DoctorManagementController doctorManagementController;
    private final UtenteManagementController utenteManagementController;
    private final AdminManagementController adminManagementController;
    private final EmployeeManagementController employeeManagementController;

    @Autowired
    AdminService adminService;

    @Autowired
    CalendarioService calendarioService;

    @GetMapping(value = "/profile")
    public String showProfile(ModelMap map){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        try {
            map.put("admin", adminService.getLogged(auth));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/admin/profile";
    }

    @GetMapping(value = "/lista-utentes")
    public String showUtentes(ModelMap map) {
        map.put("utenteList", utenteManagementController.getAllUtentes());
        return "/admin/lista-utentes";
    }

    @GetMapping(value = "/lista-medicos")
    public String showDoctors(ModelMap map) {
        map.put("doctorList", doctorManagementController.getAllDoctors());
        return "/admin/lista-medicos";
    }

    @GetMapping(value = "/lista-employees")
    public String showEmployees(ModelMap map) {
        map.put("employeeList", employeeManagementController.getAllEmployees());
        return "/admin/lista-employees";
    }

    @GetMapping(value = "/lista-admin")
    public String showAdmins(ModelMap map) {
        map.put("adminList", adminManagementController.getAllAdmin());
        return "/admin/lista-admin";
    }

    @GetMapping(value = "/settings")
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