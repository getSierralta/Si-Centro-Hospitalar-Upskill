package com.Bgrupo4.hospitalupskill.user.doctor;

import com.Bgrupo4.hospitalupskill.user.ApplicationUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DoctorService{

    private final static String USER_NOT_FOUND_MSG = "O medico %s não foi encontrado";

    private final DoctorRepository doctorRepository;
    private final ApplicationUserService applicationUserService;

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
        doctor1.setMorada(request.getMorada());
        return doctorRepository.save(doctor1);
    }
}
