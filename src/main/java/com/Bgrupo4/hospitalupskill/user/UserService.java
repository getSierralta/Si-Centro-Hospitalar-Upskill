package com.Bgrupo4.hospitalupskill.user;

import com.Bgrupo4.hospitalupskill.registration.token.ConfirmationToken;
import com.Bgrupo4.hospitalupskill.registration.token.ConfirmationTokenService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    private final static String USER_NOT_FOUND_MSG = "O usuario %s não foi encontrado";
    //If this gives error probably you dont have the lombok plugin
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ConfirmationTokenService confirmationTokenService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userRepository.findByusername(s).orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, s)));
    }

    //@PostMapping
    public String singUpUser(User user){
        boolean userExist = userRepository.findByusername(user.getUsername()).isPresent();
        if (userExist){
            // TODO check of attributes are the same and
            // TODO if email not confirmed send confirmation email.
            throw new IllegalStateException("Este usuario ja esta registrado");
        }
        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());

        user.setPassword(encodedPassword);

        userRepository.save(user);

        //Send confirmation token
        String token = UUID.randomUUID().toString();
        ConfirmationToken confirmationToken = new ConfirmationToken(token, LocalDateTime.now(), LocalDateTime.now().plusMinutes(15), user);

        confirmationTokenService.saveConfirmationToken(confirmationToken);

        // TODO sent email
        return token;
    }
    public int enableUser(String email) {
        return userRepository.enableUser(email);
    }
}
