package com.Bgrupo4.hospitalupskill.user.doctor;

import com.Bgrupo4.hospitalupskill.user.ApplicationUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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

    public void updateDoctorMorada(Long id, String morada) {
        if (doctorRepository.findById(id).isPresent()) {
            Doctor selected = doctorRepository.findById(id).get();
            selected.setMorada(morada);
            doctorRepository.save(selected);
        }
    }

    public void updateDoctorLocalidade(Long id, String localidade) {
        if (doctorRepository.findById(id).isPresent()) {
            Doctor selected = doctorRepository.findById(id).get();
            selected.setLocalidade(localidade);
            doctorRepository.save(selected);
        }
    }

    public void updateDoctorPhone(Long id, String phone) {
        if (doctorRepository.findById(id).isPresent()) {
            Doctor selected = doctorRepository.findById(id).get();
            selected.setPhone(phone);
            doctorRepository.save(selected);
        }
    }
}
