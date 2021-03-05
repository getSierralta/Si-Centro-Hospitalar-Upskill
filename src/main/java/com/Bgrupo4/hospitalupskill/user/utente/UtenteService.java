package com.Bgrupo4.hospitalupskill.user.utente;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UtenteService {

    private final static String USER_NOT_FOUND_MSG = "O utente %s não foi encontrado";

    private final UtenteRepository utenteRepository;


    public Optional<Utente> getUserById(Long id) {
        return utenteRepository.findById(id);
    }
}
