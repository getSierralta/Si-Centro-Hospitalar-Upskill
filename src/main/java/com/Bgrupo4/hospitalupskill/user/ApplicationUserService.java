package com.Bgrupo4.hospitalupskill.user;

import com.Bgrupo4.hospitalupskill.user.registration.token.ConfirmationToken;
import com.Bgrupo4.hospitalupskill.user.registration.token.ConfirmationTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class ApplicationUserService implements UserDetailsService {

    private final static String USER_NOT_FOUND_MSG = "O usuario %s não foi encontrado";
    private final ApplicationUserRepository applicationUserRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ConfirmationTokenService confirmationTokenService;

    @Autowired
    public ApplicationUserService(ApplicationUserRepository applicationUserRepository, BCryptPasswordEncoder bCryptPasswordEncoder, ConfirmationTokenService confirmationTokenService) {
        this.applicationUserRepository = applicationUserRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.confirmationTokenService = confirmationTokenService;
    }
    public void enableUser(String email) {
        applicationUserRepository.enableUser(email);
    }

    public List<ApplicationUser> getUsers() {
        return applicationUserRepository.findAll();
    }

    public ApplicationUser getUserById(Long id) throws UsernameNotFoundException {
        return applicationUserRepository.findById(id).orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, id)));
    }

    public void enableAndSave(ApplicationUser user){
        boolean userExist = applicationUserRepository.findByUsername(user.getUsername()).isPresent();
        if (userExist){
            throw new IllegalStateException("Este usuario ja esta registrado");
        }
        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        user.setEnabled(true);
        applicationUserRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return applicationUserRepository.findByUsername(s).orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, s)));
    }

    /**
     * AQUI É ONDE SE FAZ REGISTRO
     * @param user Usuario
     * @return token
     */
    public String singUpUser(ApplicationUser user){
        boolean userExist = applicationUserRepository.findByUsername(user.getUsername()).isPresent();
        if (userExist){
            // TODO check of attributes are the same and
            // TODO if email not confirmed send confirmation email.
            throw new IllegalStateException("Este usuario ja esta registrado");
        }
        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());

        user.setPassword(encodedPassword);

        applicationUserRepository.save(user);

        //Send confirmation token
        String token = UUID.randomUUID().toString();
        ConfirmationToken confirmationToken = new ConfirmationToken(token, LocalDateTime.now(), LocalDateTime.now().plusMinutes(15), user);

        confirmationTokenService.saveConfirmationToken(confirmationToken);

        return token;
    }

}
