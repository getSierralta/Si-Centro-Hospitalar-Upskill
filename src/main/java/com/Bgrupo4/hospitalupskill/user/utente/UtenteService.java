package com.Bgrupo4.hospitalupskill.user.utente;


import com.Bgrupo4.hospitalupskill.email.EmailSender;
import com.Bgrupo4.hospitalupskill.registration.EmailValidator;
import com.Bgrupo4.hospitalupskill.registration.RegistrationService;
import com.Bgrupo4.hospitalupskill.user.ApplicationUserService;
import com.Bgrupo4.hospitalupskill.user.UserRole;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UtenteService {

    private final static String USER_NOT_FOUND_MSG = "O utente %s não foi encontrado";

    @Autowired
    private final UtenteRepository utenteRepository;
    private final EmailValidator emailValidator;
    private final ApplicationUserService applicationUserService;
    private final EmailSender emailSender;
    private final RegistrationService registrationService;

    public Optional<Utente> getUserById(Long id) {
        return utenteRepository.findById(id);
    }

    public List<Utente> getAllUtentes() {
        return utenteRepository.findAll();
    }

    public String registerUtente(UtenteRegistrationRequest request) {
        System.out.println("inside the register 1");
        boolean isValidEmail = emailValidator.test(request.getEmail());
        if (!isValidEmail) {
            throw new IllegalStateException("email not valid");
        }
        System.out.println("inside the register 2");
        //Todo we should check the request before doing the user cause it gives error if the user is not complete
        String token = applicationUserService.singUpUser(new Utente(
                request.getNif(),
                request.getName(),
                request.getUsername(),
                request.getEmail(),
                request.getPassword(),
                request.getMorada(),
                request.getLocalidade(),
                request.getTelemovel(),
                request.getDataDeNascimento(),
                UserRole.UTENTE,
                request.getApolice()));
        System.out.println("inside the register 3");
        String link = "http://localhost:8080/utente/register/confirm?token=" + token;
        emailSender.senad(request.getEmail(), registrationService.buildEmail(request.getName(), link));
        System.out.println("inside the register 4");
        return token;
    }

    public Utente updateUtente(Long id, UtenteRequest request) {
        Optional<Utente> utente = utenteRepository.findById(id);
        if (!utente.isPresent()) {
            throw new EntityNotFoundException(String.format("Utente %s não foi encontrado", id));
        }
        Utente utente1 = utente.get();
        utente1.setName(request.getName());
        utente1.setUsername(request.getUsername());
        utente1.setApolice(request.getApolice());

        return utenteRepository.save(utente1);
    }


}
