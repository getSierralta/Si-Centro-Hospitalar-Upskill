package com.Bgrupo4.hospitalupskill.user.doctor;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DoctorService{

    private final static String USER_NOT_FOUND_MSG = "O medico %s não foi encontrado";

    private final DoctorRepository doctorRepository;


}
