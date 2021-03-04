package com.Bgrupo4.hospitalupskill.user.utente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UtenteService implements UserDetailsService {

    private final static String USER_NOT_FOUND_MSG = "O utente %s não foi encontrado";

    private final UtenteRepository utenteRepository;

    @Autowired
    public UtenteService(UtenteRepository utenteRepository) {
        this.utenteRepository = utenteRepository;
    }

    //LOGIN
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return utenteRepository.findByUsername(s).orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, s)));
    }

    public Optional<Utente> getUserById(Long id) {
        return utenteRepository.findById(id);
    }
}
