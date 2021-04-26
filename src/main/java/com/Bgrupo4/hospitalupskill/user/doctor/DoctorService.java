package com.Bgrupo4.hospitalupskill.user.doctor;

import com.Bgrupo4.hospitalupskill.user.ApplicationUserService;
import com.Bgrupo4.hospitalupskill.user.doctor.especialidade.Especialidade;
import com.Bgrupo4.hospitalupskill.user.doctor.especialidade.EspecialidadeRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityNotFoundException;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DoctorService{

    private final static String USER_NOT_FOUND_MSG = "O medico %s não foi encontrado";

    private final DoctorRepository doctorRepository;
    private final ApplicationUserService applicationUserService;
    private final EspecialidadeRepository especialidadeRepository;

    public Optional<Doctor> getUserById(Long id) {
        return doctorRepository.findById(id);
    }

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public void deleteDoctor(Long id) {
        doctorRepository.deleteById(id);
    }

    public void registerDoctor(Doctor doctor) {
        applicationUserService.enableAndSave(doctor);
    }

    public Doctor updateDoctor(Long id, DoctorRequest request) {
        Optional<Doctor> doctor = doctorRepository.findById(id);
        if (!doctor.isPresent()) {
            throw new EntityNotFoundException(String.format("Médico %s não foi encontrado", id));
        }
        Doctor doctor1 = doctor.get();
        if (!request.getLocalidade().isEmpty()){
            doctor1.setLocalidade(request.getLocalidade());
        }
        if (!request.getMorada().isEmpty()){
            doctor1.setMorada(request.getMorada());
        }
        if (!request.getTelemovel().isEmpty()){
            doctor1.setPhone(request.getTelemovel());
        }
        if (!request.getName().isEmpty()){
            doctor1.setName(request.getName());
        }
        return doctorRepository.save(doctor1);
    }

    public Optional<Doctor> getUserByUsername(String username) {
        return doctorRepository.findByUsername(username);
    }
    public Doctor getLogged(Authentication auth) throws Exception {
        String principal = auth.getPrincipal().toString();
        String[] split = principal.split("username='");
        String[] split2 = split[1].split("',");
        Optional<Doctor> doctor = getUserByUsername(split2[0]);
        if (!doctor.isPresent()){
            throw new Exception("There's no logged person");
        }
        return doctor.get();
    }

    public Doctor updateDoctor(Doctor doctor, DoctorUpdateRequest request) {
        // if ( passwordEncoder.bCryptPasswordEncoder().encode(request.getPassword()).matches(utente.getPassword())){

        if (!request.getLocalidade().isEmpty()){
            doctor.setLocalidade(request.getLocalidade());
        }
        if (!request.getMorada().isEmpty()){
            doctor.setMorada(request.getMorada());
        }
        if (!request.getTelemovel().isEmpty()){
            doctor.setPhone(request.getTelemovel());
        }
        if (!request.getName().isEmpty()){
            doctor.setName(request.getName());
        }

        return doctorRepository.save(doctor);
        //}
        //throw new IllegalArgumentException("Palavra passe incorrect");
    }

    public Doctor updateDoctor(Doctor doctor, MultipartFile imageFile) throws  Exception{
        String folder = "/imagens/";
        byte[] bytes = imageFile.getBytes();
        String rootDir = System.getProperty("user.dir");
        Path path = Paths.get(rootDir + folder + imageFile.getOriginalFilename());
        imageFile.transferTo(new File(String.valueOf(path)));
        doctor.setProfilePicture(imageFile.getOriginalFilename());
        return doctorRepository.save(doctor);
    }

    public Especialidade createEspecialidade(String especialidade) {
         return especialidadeRepository.save(new Especialidade(especialidade));
    }

    public Doctor getDoctorByNif(String nif) {
        return doctorRepository.findByNif(nif);
    }

    public List<Doctor> getDoctorByEspecialidade(String especialidade) {
       return doctorRepository.findByEspecialidade(especialidadeRepository.findByEspecialidade(especialidade));
    }
}
