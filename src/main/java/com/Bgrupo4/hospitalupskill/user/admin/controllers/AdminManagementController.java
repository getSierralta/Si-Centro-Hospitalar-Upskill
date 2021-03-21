package com.Bgrupo4.hospitalupskill.user.admin.controllers;

import com.Bgrupo4.hospitalupskill.calendario.EspecialidadeRequest;
import com.Bgrupo4.hospitalupskill.registration.RegistrationService;
import com.Bgrupo4.hospitalupskill.user.SearchRequest;
import com.Bgrupo4.hospitalupskill.user.admin.*;
import com.Bgrupo4.hospitalupskill.user.doctor.Doctor;
import com.Bgrupo4.hospitalupskill.user.doctor.DoctorRequest;
import com.Bgrupo4.hospitalupskill.user.doctor.Especialidade;
import com.Bgrupo4.hospitalupskill.user.doctor.especialidade.Especialidade;
import com.Bgrupo4.hospitalupskill.user.doctor.especialidade.EspecialidadeRequest;
import com.Bgrupo4.hospitalupskill.user.utente.Utente;
import com.Bgrupo4.hospitalupskill.user.utente.UtenteUpdateRequest;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin")
@AllArgsConstructor
public class AdminManagementController {

    @Autowired
    private AdminService adminService;


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


    @PostMapping(path = "/update", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public RedirectView update(AdminUpdateRequest request) throws Exception {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Admin admin = adminService.getLogged(auth);
        adminService.updateAdmin(admin, request);
        return new RedirectView("/admin/settings");
    }

    @PostMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Admin> updateEmployee(AdminRequest request, @PathVariable Long id) {
        return ResponseEntity.ok(adminService.updateAdmin(id, request));
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
    public ModelAndView doctorregister(DoctorRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            adminService.registerNew(request);
            modelAndView.setViewName("/admin/register-success");
        } catch (Exception e) {
            modelAndView.setViewName("/admin/register-error");
        }
        return modelAndView;
    }

    @PostMapping(path = "/new-especialidade", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ModelAndView newEspecialidade(EspecialidadeRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        adminService.createEspecialidade(request.getEspecialidade());
        modelAndView.setViewName("/admin/register-success");
        return modelAndView;
    }

    @PostMapping(path = "/delete-especialidade", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ModelAndView deleteEspecialidade(EspecialidadeRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        adminService.deleteEspecialidade(request.getEspecialidade());
        modelAndView.setViewName("/admin/register-success");
        return modelAndView;
    }

    @PostMapping("/delete/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void apagarAdmin(@PathVariable Long id) {
        adminService.deleteAdmin(id);
    }

    @PostMapping(path = "/uploadImage")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public RedirectView updateImage(@RequestParam("imageFile") MultipartFile imageFile) throws Exception {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Admin admin = adminService.getLogged(auth);
        try {
            adminService.updateAdmin(admin, imageFile);
        }catch (Exception e){
            e.printStackTrace();
            return new RedirectView("/500");
        }
        return new RedirectView("/admin/settings");
    }

    @PostMapping("/username")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public RedirectView searchUsername(SearchRequest request) {
        return new RedirectView("/admin/lista-admin/username/"+request.getUser());
    }

    @PostMapping("/nif")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public RedirectView searchId(SearchRequest request) {
        return new RedirectView("/admin/lista-admin/nif/"+request.getUser());
    }

    @PostMapping("/especialidade")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public RedirectView searchEspecialidade(EspecialidadeRequest request) {
        return new RedirectView("/admin/lista-medicos/especialidade/"+request.getEspecialidade());
    }

}


