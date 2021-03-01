package com.Bgrupo4.hospitalupskill.registration;

import com.Bgrupo4.hospitalupskill.registration.token.ConfirmationToken;
import com.Bgrupo4.hospitalupskill.registration.token.ConfirmationTokenService;
import com.Bgrupo4.hospitalupskill.user.User;
import com.Bgrupo4.hospitalupskill.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class RegistrationService {

    // if this gives error you probably dont have the lombok plugin installed
    private final EmailValidator emailValidator;
    private final UserService userService;
    private final ConfirmationTokenService confirmationTokenService;

    public String register(RegistrationRequest request) {
        boolean isValidEmail = emailValidator.test(request.getEmail());
        if(!isValidEmail){
            throw new IllegalStateException("email not valid");
        }
        return userService.singUpUser(
                new User(
                        request.getUtente(),
                        request.getName(),
                        request.getUsername(),
                        request.getEmail(),
                        request.getPassword()
                ));
    }

    @Transactional
    public String confirmToken(String token) {
        ConfirmationToken confirmationToken = confirmationTokenService
                .getToken(token)
                .orElseThrow(() ->
                        new IllegalStateException("token not found"));

        if (confirmationToken.getConfirmedAt() != null) {
            throw new IllegalStateException("email ja foi confirmado");
        }

        LocalDateTime expiredAt = confirmationToken.getExpiresAt();

        if (expiredAt.isBefore(LocalDateTime.now())) {
            throw new IllegalStateException("token fora da data");
        }

        confirmationTokenService.setConfirmedAt(token);
        userService.enableUser(
                confirmationToken.getUser().getEmail());
        return "confirmed";
    }
}
