package com.Bgrupo4.hospitalupskill.user.admin;

import com.Bgrupo4.hospitalupskill.user.ApplicationUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AdminService {
    private final static String USER_NOT_FOUND_MSG = "O administrador %s não foi encontrado";

    private final AdminRepository adminRepository;
    private final ApplicationUserService applicationUserService;

    public Optional<Admin> getUserById(Long id) {
        return adminRepository.findById(id);
    }

    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    public void deleteAdmin(Long id) {
        adminRepository.deleteById(id);
    }

    public void registerAdmin(Admin admin) {
        applicationUserService.enableAndSave(admin);
    }

    public Admin updateAdmin(Long id, AdminRequest request) {
        Optional<Admin> admin = adminRepository.findById(id);
        if (admin.isEmpty()) {
            throw new EntityNotFoundException(String.format("Administrador %s não foi encontrado", id));
        }
        Admin admin1 = admin.get();
        admin1.setMorada(request.getMorada());
        return adminRepository.save(admin1);
    }
}
