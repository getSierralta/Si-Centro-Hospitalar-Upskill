package com.Bgrupo4.hospitalupskill.user.admin;

import com.Bgrupo4.hospitalupskill.user.ApplicationUserService;
import com.Bgrupo4.hospitalupskill.user.UserRole;
import com.Bgrupo4.hospitalupskill.user.doctor.Doctor;
import com.Bgrupo4.hospitalupskill.user.employee.Employee;
import com.Bgrupo4.hospitalupskill.user.utente.Utente;
import com.Bgrupo4.hospitalupskill.user.utente.UtenteRegistrationRequest;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.sql.SQLIntegrityConstraintViolationException;
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

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void registerNew(AdminRegistrationRequest request) throws Exception {
        try {
            String[] data = request.getDataDeNascimento().split("-");
            switch (request.getRole()) {
                case "employee":
                    applicationUserService.enableAndSave(new Employee(
                            request.getNif(),
                            request.getName(),
                            request.getUsername(),
                            request.getEmail(),
                            request.getPassword(),
                            request.getMorada(),
                            request.getLocalidade(),
                            request.getTelemovel(),
                            new GregorianCalendar(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2])),
                            UserRole.COLABORADOR.toString()));
                    break;
                case "responsavel":
                    applicationUserService.enableAndSave(new Employee(
                            request.getNif(),
                            request.getName(),
                            request.getUsername(),
                            request.getEmail(),
                            request.getPassword(),
                            request.getMorada(),
                            request.getLocalidade(),
                            request.getTelemovel(),
                            new GregorianCalendar(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2])),
                            UserRole.RESPONSAVEL.toString()));
                    break;
                case "admin":
                    applicationUserService.enableAndSave(new Admin(
                            request.getNif(),
                            request.getName(),
                            request.getUsername(),
                            request.getEmail(),
                            request.getPassword(),
                            request.getMorada(),
                            request.getLocalidade(),
                            request.getTelemovel(),
                            new GregorianCalendar(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2])),
                            UserRole.ADMIN.toString()
                    ));
                    break;
            }
        }catch (Exception e){
            throw new Exception();
        }
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void registerNew(DoctorRegistrationRequest request) throws Exception {
        try {
            String[] data = request.getDataDeNascimento().split("-");
                applicationUserService.enableAndSave(new Doctor(
                        request.getNif(),
                        request.getName(),
                        request.getUsername(),
                        request.getEmail(),
                        request.getPassword(),
                        request.getMorada(),
                        request.getLocalidade(),
                        request.getTelemovel(),
                        new GregorianCalendar(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2])),
                        request.getCedula(),
                        request.getEspecialidade()
                        ));
        }catch (Exception e){
            throw new Exception();
        }
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
