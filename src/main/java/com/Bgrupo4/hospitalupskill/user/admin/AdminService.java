package com.Bgrupo4.hospitalupskill.user.admin;

import com.Bgrupo4.hospitalupskill.user.ApplicationUser;
import com.Bgrupo4.hospitalupskill.user.ApplicationUserService;
import com.Bgrupo4.hospitalupskill.user.UserRole;
import com.Bgrupo4.hospitalupskill.user.doctor.*;
import com.Bgrupo4.hospitalupskill.user.employee.Employee;
import com.Bgrupo4.hospitalupskill.user.employee.EmployeeRepository;
import com.Bgrupo4.hospitalupskill.user.utente.Utente;
import com.Bgrupo4.hospitalupskill.user.utente.UtenteRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AdminService {

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    private final AdminRepository adminRepository;
    private final EmployeeRepository employeeRepository;
    private final UtenteRepository utenteRepository;
    private final DoctorRepository doctorRepository;
    private final EspecialidadeRepository especialidadeRepository;

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

    public void updateAdmin(Long id, AdminRequest request) {
        Optional<Admin> admin = adminRepository.findById(id);
        if (admin.isEmpty()) {
            throw new EntityNotFoundException(String.format("Administrador %s não foi encontrado", id));
        }
        ApplicationUser user = requestProcess(admin.get(), request);
        adminRepository.save((Admin) user);
    }

    public void updateEmployee(Long id, AdminRequest request) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isEmpty()) {
            throw new EntityNotFoundException(String.format("Colaborador %s não foi encontrado", id));
        }
        ApplicationUser user = requestProcess(employee.get(), request);
        employeeRepository.save((Employee) user);
    }

    public void updateUtente(Long id, AdminRequest request) {
        Optional<Utente> utente = utenteRepository.findById(id);
        if (utente.isEmpty()) {
            throw new EntityNotFoundException(String.format("Utente %s não foi encontrado", id));
        }
        ApplicationUser user = requestProcess(utente.get(), request);
        utenteRepository.save((Utente) user);
    }

    public ApplicationUser requestProcess(ApplicationUser user, AdminRequest request){
        if(!request.getUsername().isEmpty()){
            user.setUsername(request.getUsername());
        }
        if(!request.getName().isEmpty()){
            user.setName(request.getName());
        }
        if(!request.getPassword().isEmpty()){
            String encodedPassword = bCryptPasswordEncoder.encode(request.getPassword());
            user.setPassword(encodedPassword);
        }
        if(!request.getMorada().isEmpty()){
            user.setMorada(request.getMorada());
        }
        if(!request.getLocalidade().isEmpty()){
            user.setLocalidade(request.getLocalidade());
        }
        if(!request.getTelemovel().isEmpty()){
            user.setPhone(request.getTelemovel());
        }
        if(!request.getDataDeNascimento().isEmpty()){
            String[] data = request.getDataDeNascimento().split("-");
            user.setDataDeNascimento(
                    new GregorianCalendar(
                            Integer.parseInt(data[0]),
                            Integer.parseInt(data[1]),
                            Integer.parseInt(data[2])
                    )
            );
        }
        return user;
    }



    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void registerNew(AdminRequest request) throws Exception {
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
    public void registerNew(DoctorRequest request) throws Exception {
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
                        getEspecialidade(request.getEspecialidade())
                        ));
        }catch (Exception e){
            throw new Exception();
        }
    }

    private Especialidade getEspecialidade(String especialidade) {
        for (Especialidade esp: especialidadeRepository.findAll()) {
            if(esp.getEspecialidade().equals(especialidade)){
                return esp;
            }
        }
        throw new IllegalArgumentException("Especialidade não existe");
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
