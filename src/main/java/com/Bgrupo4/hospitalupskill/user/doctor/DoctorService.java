package com.Bgrupo4.hospitalupskill.user.doctor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class DoctorService  implements UserDetailsService {

    private final static String USER_NOT_FOUND_MSG = "O medico %s não foi encontrado";

    private final DoctorRepository doctorRepository;

    @Autowired
    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    //LOGIN
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return doctorRepository.findByUsername(s).orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, s)));
    }
}
