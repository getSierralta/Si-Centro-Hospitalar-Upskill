package com.Bgrupo4.hospitalupskill.user.employee;

import com.Bgrupo4.hospitalupskill.senha.Senha;
import com.Bgrupo4.hospitalupskill.senha.SenhaRepository;
import com.Bgrupo4.hospitalupskill.senha.SenhaService;
import com.Bgrupo4.hospitalupskill.user.ApplicationUserService;
import com.Bgrupo4.hospitalupskill.user.utente.Utente;
import com.Bgrupo4.hospitalupskill.user.utente.UtenteRequest;
import com.Bgrupo4.hospitalupskill.user.utente.UtenteService;
import com.Bgrupo4.hospitalupskill.user.utente.UtenteUpdateRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityNotFoundException;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import static com.Bgrupo4.hospitalupskill.HospitalUpskillApplication.ECRA;

@Service
@AllArgsConstructor
public class EmployeeService {
    private final static String USER_NOT_FOUND_MSG = "O colaborador %s não foi encontrado";

    private final EmployeeRepository employeeRepository;
    private final ApplicationUserService applicationUserService;
    private final UtenteService utenteService;
    private final SenhaService senhaService;
    private final SenhaRepository senhaRepository;

    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    public void registerEmployee(Employee employee) {
        applicationUserService.enableAndSave(employee);
    }

    public Employee updateEmployee(Long id, EmployeeRequest request) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if (employeeOptional.isPresent()) {
            throw new EntityNotFoundException(String.format("Colaborador %s não foi encontrado", id));
        }
        Employee employee = employeeOptional.get();
        if (!request.getLocalidade().isEmpty()){
            employee.setLocalidade(request.getLocalidade());
        }
        if (!request.getMorada().isEmpty()){
            employee.setMorada(request.getMorada());
        }
        if (!request.getTelemovel().isEmpty()){
            employee.setPhone(request.getTelemovel());
        }
        if (!request.getName().isEmpty()){
            employee.setName(request.getName());
        }
        return employeeRepository.save(employee);
    }
    public Employee updateEmployee(Employee employee, EmployeeUpdateRequest request) {
        // if ( passwordEncoder.bCryptPasswordEncoder().encode(request.getPassword()).matches(utente.getPassword())){
        if (!request.getLocalidade().isEmpty()){
            employee.setLocalidade(request.getLocalidade());
        }
        if (!request.getMorada().isEmpty()){
            employee.setMorada(request.getMorada());
        }
        if (!request.getTelemovel().isEmpty()){
            employee.setPhone(request.getTelemovel());
        }
        if (!request.getName().isEmpty()){
            employee.setName(request.getName());
        }

        return employeeRepository.save(employee);
        //}
        //throw new IllegalArgumentException("Palavra passe incorrect");
    }

    public Employee updateEmployee(Employee employee, MultipartFile imageFile) throws  Exception{
        String folder = "/imagens/colaborador/";
        String rootDir = System.getProperty("user.dir");
        Path path = Paths.get(rootDir + folder + imageFile.getOriginalFilename());
        imageFile.transferTo(new File(String.valueOf(path)));
        employee.setProfilePicture(imageFile.getOriginalFilename());
        return employeeRepository.save(employee);
    }

    // EMPLOYEE
    @GetMapping(path = "/find-utente/all")
    public List<Utente> getAllUtentes() {
        return utenteService.getAllUtentes();
    }

    @GetMapping(path = "/find-utente/{id}")
    public Optional<Utente> getUtenteById(@PathVariable("id") Long id) {
        return utenteService.getUserById(id);
    }

    @PostMapping("/update-utente/{id}")
    public ResponseEntity<Utente> updateUtente(@RequestBody UtenteRequest request, @PathVariable Long id) {
        return ResponseEntity.ok(utenteService.updateUtente(id, request));
    }

    public Optional<Employee> getUserByUsername(String username) {
        return employeeRepository.findByUsername(username);
    }

    public Employee getLogged(Authentication auth) throws Exception {
        String principal = auth.getPrincipal().toString();
        String[] split = principal.split("username='");
        String[] split2 = split[1].split("',");
        Optional<Employee> employee = getUserByUsername(split2[0]);
        if (!employee.isPresent()){
            throw new Exception("There's no logged person");
        }
        return employee.get();
    }

    public void callNextClient(Employee employee) {
        for (Senha senha: senhaService.getSenhasByColaborador(employee)) {
            ECRA.remove(senha.getNumeroSenha());
        }
        if (!senhaService.getSenhasColaborador().isEmpty()){
            Senha senha = senhaService.getSenhasColaborador().get(0);
            senha.setFoiAtentido(true);
            senha.setColaborador(employee);
            ECRA.add(senha.getNumeroSenha());
            senhaRepository.save(senha);
        }
    }

    public Employee getEmployeeByNif(String nif) {
        return employeeRepository.findByNif(nif);
    }
}
