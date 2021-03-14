package com.Bgrupo4.hospitalupskill.user.admin.controllers;

import com.Bgrupo4.hospitalupskill.user.admin.Admin;
import com.Bgrupo4.hospitalupskill.user.admin.AdminRepository;
import com.Bgrupo4.hospitalupskill.user.admin.AdminRequest;
import com.Bgrupo4.hospitalupskill.user.admin.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/admin")
@AllArgsConstructor
public class AdminManagementController {

    @Autowired
    private AdminService adminService;

    private final AdminRepository adminRepository;
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();

    @GetMapping(path = "{id}")
    @PreAuthorize("hasAuthority('colaborador:read')")
    public Optional<Admin> getAdmin(@PathVariable("id") Long id){
        return adminService.getUserById(id);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('colaborador:read')")
    public List<Admin> getAllAdmin() {
        return adminService.getAllAdmins();
    }

    @DeleteMapping(path = "{id}")
    @PreAuthorize("hasAuthority('colaborador:write')")
    public void deleteAdmin(@PathVariable("id") Long id){
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

    public Admin getLogged(Authentication auth) throws Exception {
        String principal = auth.getPrincipal().toString();
        String[] split = principal.split("username='");
        String[] split2 = split[1].split("',");
        Optional<Admin> admin = getUserByUsername(split2[0]);
        if (admin.isEmpty()){
            throw new Exception("There's no logged person");
        }
        return admin.get();
    }

    public Optional<Admin> getUserByUsername(String username) {
        return adminRepository.findByUsername(username);
    }
}
