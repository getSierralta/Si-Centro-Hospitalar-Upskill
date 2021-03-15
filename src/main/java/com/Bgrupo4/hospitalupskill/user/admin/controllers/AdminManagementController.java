package com.Bgrupo4.hospitalupskill.user.admin.controllers;

import com.Bgrupo4.hospitalupskill.registration.RegistrationService;
import com.Bgrupo4.hospitalupskill.user.admin.*;
import com.Bgrupo4.hospitalupskill.user.utente.UtenteRegistrationRequest;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin")
@AllArgsConstructor
public class AdminManagementController {

    @Autowired
    private AdminService adminService;

    private final RegistrationService registrationService;
    private final AdminRepository adminRepository;

    @GetMapping(path = "{id}")
    @PreAuthorize("hasAuthority('colaborador:read')")
    public Optional<Admin> getAdmin(@PathVariable("id") Long id) {
        return adminService.getUserById(id);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('colaborador:read')")
    public List<Admin> getAllAdmin() {
        return adminService.getAllAdmins();
    }

    @DeleteMapping(path = "{id}")
    @PreAuthorize("hasAuthority('colaborador:write')")
    public void deleteAdmin(@PathVariable("id") Long id) {
        adminService.deleteAdmin(id);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('colaborador:write')")
    public void registerNewAdmin(@Validated @RequestBody Admin admin) {
        adminService.registerAdmin(admin);
    }

    @PutMapping(path = "{id}")
    @PreAuthorize("hasAuthority('colaborador:write')")
    public void updateAdmin(@PathVariable("id") Long id, @RequestBody AdminRequest request) {
        adminService.updateAdmin(id, request);
    }

    @PostMapping(path = "/register-employee", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ModelAndView adminregister(AdminRegistrationRequest request) {
        adminService.registerNew(request);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/register-success");
        return modelAndView;
    }

}


