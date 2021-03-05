package com.Bgrupo4.hospitalupskill.user;

import com.Bgrupo4.hospitalupskill.user.employee.Employee;
import com.Bgrupo4.hospitalupskill.user.employee.EmployeeRepository;
import com.Bgrupo4.hospitalupskill.user.doctor.Doctor;
import com.Bgrupo4.hospitalupskill.user.doctor.DoctorRepository;
import com.Bgrupo4.hospitalupskill.user.utente.registration.token.ConfirmationToken;
import com.Bgrupo4.hospitalupskill.user.utente.registration.token.ConfirmationTokenService;
import com.Bgrupo4.hospitalupskill.user.utente.Utente;
import com.Bgrupo4.hospitalupskill.user.utente.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class ApplicationUserService implements UserDetailsService {

    private final static String USER_NOT_FOUND_MSG = "O usuario %s não foi encontrado";
    private final UtenteRepository utenteRepository;
    private final EmployeeRepository employeeRepository;
    private final DoctorRepository doctorRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ConfirmationTokenService confirmationTokenService;

    @Autowired
    public ApplicationUserService( UtenteRepository utenteRepository, EmployeeRepository employeeRepository, DoctorRepository doctorRepository, BCryptPasswordEncoder bCryptPasswordEncoder, ConfirmationTokenService confirmationTokenService) {
        this.utenteRepository = utenteRepository;
        this.employeeRepository = employeeRepository;
        this.doctorRepository = doctorRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.confirmationTokenService = confirmationTokenService;
    }
    public void enableUser(String email, String userRole) {
        switch (userRole) {
            case "UTENTE":
                utenteRepository.enableUser(email);
                break;
            case "MEDICO":
            case "MEDICO_RESPONSAVEL":
                doctorRepository.enableUser(email);
                break;
            case "RESPONSAVEL":
            case "COLABORADOR":
            case "ADMIN":
            case "COLABORADOR_RESPONSAVEL":
                employeeRepository.enableUser(email);
                break;
        }
    }


    public void enableAndSave(Utente user){
        boolean userExist = utenteRepository.findByUsername(user.getUsername()).isPresent();
        if (userExist){
            throw new IllegalStateException("Este usuario ja esta registrado");
        }
        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        user.setEnabled(true);
        utenteRepository.save(user);
    }
    public void enableAndSave(Doctor user){
        boolean userExist = doctorRepository.findByUsername(user.getUsername()).isPresent();
        if (userExist){
            throw new IllegalStateException("Este usuario ja esta registrado");
        }
        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        user.setEnabled(true);
        doctorRepository.save(user);
    }

    public void enableAndSave(Employee user){
        boolean userExist = employeeRepository.findByUsername(user.getUsername()).isPresent();
        if (userExist){
            throw new IllegalStateException("Este usuario ja esta registrado");
        }
        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        user.setEnabled(true);
        employeeRepository.save(user);
    }

    //LOGIN
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserDetails userDetails;
        try {
            userDetails = utenteRepository.findByUsername(s).orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, s)));
            return userDetails;
        }catch(UsernameNotFoundException ignored){}
        try {
            userDetails = employeeRepository.findByUsername(s).orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, s)));
            return userDetails;
        }catch(UsernameNotFoundException ignored){}
        try {
            userDetails = doctorRepository.findByUsername(s).orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, s)));
            return userDetails;
        }catch(UsernameNotFoundException ignored){}
        throw new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, s));
    }

    /**
     * AQUI É ONDE SE FAZ REGISTRO
     * @param user Utente
     * @return token
     */
    public String singUpUser(Utente user){
        boolean userExist = utenteRepository.findByUsername(user.getUsername()).isPresent();
        if (userExist){
            // TODO check of attributes are the same and
            // TODO if email not confirmed send confirmation email.
            throw new IllegalStateException("Este usuario ja esta registrado");
        }
        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        utenteRepository.save(user);
        //Send confirmation token
        String token = UUID.randomUUID().toString();
        ConfirmationToken confirmationToken = new ConfirmationToken(token, LocalDateTime.now(), LocalDateTime.now().plusMinutes(15), user);
        confirmationTokenService.saveConfirmationToken(confirmationToken);
        return token;
    }


}
