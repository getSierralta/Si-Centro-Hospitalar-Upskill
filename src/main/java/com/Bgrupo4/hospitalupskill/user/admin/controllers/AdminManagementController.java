package com.Bgrupo4.hospitalupskill.user.admin.controllers;

import com.Bgrupo4.hospitalupskill.registration.RegistrationService;
import com.Bgrupo4.hospitalupskill.user.admin.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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
    public ModelAndView adminregister(AdminRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            adminService.registerNew(request);
            modelAndView.setViewName("/admin/register-success");
        } catch (Exception e) {
            modelAndView.setViewName("/admin/register-error");
        }
        return modelAndView;
    }

    @PostMapping(path = "/register-doctor", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ModelAndView adminregister(DoctorRegistrationRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            adminService.registerNew(request);
            modelAndView.setViewName("/admin/register-success");
        } catch (Exception e) {
            modelAndView.setViewName("/admin/register-error");
        }
        return modelAndView;
    }

    @PostMapping(path = "/lista-utentes", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ModelAndView adminregister() {
        ModelAndView modelAndView = new ModelAndView();


        modelAndView.setViewName("/admin/lista-utentes");
        return modelAndView;
    }

}


