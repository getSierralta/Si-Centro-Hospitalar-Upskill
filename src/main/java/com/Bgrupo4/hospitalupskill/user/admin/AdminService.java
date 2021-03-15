package com.Bgrupo4.hospitalupskill.user.admin;

import com.Bgrupo4.hospitalupskill.user.ApplicationUserService;
import com.Bgrupo4.hospitalupskill.user.UserRole;
import com.Bgrupo4.hospitalupskill.user.doctor.Doctor;
import com.Bgrupo4.hospitalupskill.user.employee.Employee;
import com.Bgrupo4.hospitalupskill.user.utente.Utente;
import com.Bgrupo4.hospitalupskill.user.utente.UtenteRegistrationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.GregorianCalendar;
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

    public void registerNew(AdminRegistrationRequest request) {
        String[] data = request.getDataDeNascimento().split("-");
        switch (request.getRole()) {
            case "employee":
                applicationUserService.singUpEmployee(new Employee(
                        request.getNif(),
                        request.getName(),
                        request.getUsername(),
                        request.getEmail(),
                        request.getPassword(),
                        request.getMorada(),
                        request.getLocalidade(),
                        request.getTelemovel(),
                        new GregorianCalendar(Integer.valueOf(data[0]), Integer.valueOf(data[1]), Integer.valueOf(data[2])),
                        UserRole.COLABORADOR.toString()));
                break;
            case "doctor":
                applicationUserService.singUpDoctor(new Doctor(
                        request.getNif(),
                        request.getName(),
                        request.getUsername(),
                        request.getEmail(),
                        request.getPassword(),
                        request.getMorada(),
                        request.getLocalidade(),
                        request.getTelemovel(),
                        new GregorianCalendar(Integer.valueOf(data[0]), Integer.valueOf(data[1]), Integer.valueOf(data[2])),
                        request.getCedula(),
                        request.getEspecialidade()));
                break;
            case "responsavel":
                applicationUserService.singUpResponsavel(new Responsavel(
                        request.getNif(),
                        request.getName(),
                        request.getUsername(),
                        request.getEmail(),
                        request.getPassword(),
                        request.getMorada(),
                        request.getLocalidade(),
                        request.getTelemovel(),
                        new GregorianCalendar(Integer.valueOf(data[0]), Integer.valueOf(data[1]), Integer.valueOf(data[2])),
                        UserRole.RESPONSAVEL.toString()));
                break;
            case "admin":
                applicationUserService.singUpAdmin(new Admin(
                        request.getNif(),
                        request.getName(),
                        request.getUsername(),
                        request.getEmail(),
                        request.getPassword(),
                        request.getMorada(),
                        request.getLocalidade(),
                        request.getTelemovel(),
                        new GregorianCalendar(Integer.valueOf(data[0]), Integer.valueOf(data[1]), Integer.valueOf(data[2])), ));
                break;
        }
    }
}
