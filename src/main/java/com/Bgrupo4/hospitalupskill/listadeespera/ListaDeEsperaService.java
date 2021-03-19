package com.Bgrupo4.hospitalupskill.listadeespera;

import com.Bgrupo4.hospitalupskill.user.doctor.Especialidade;
import com.Bgrupo4.hospitalupskill.user.utente.Utente;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListaDeEsperaService {

    private final ListaDeEsperaRepository listaDeEsperaRepository;

    public ListaDeEspera add(Utente utente1, Especialidade especialidade) {
        return listaDeEsperaRepository.save(new ListaDeEspera(utente1, especialidade));
    }

    public void activate() {
        for (ListaDeEspera li: listaDeEsperaRepository.findAll()) {

        }
    }
}
