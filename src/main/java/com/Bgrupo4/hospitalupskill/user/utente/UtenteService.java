package com.Bgrupo4.hospitalupskill.user.utente;

import com.Bgrupo4.hospitalupskill.consultas.Status;
import com.Bgrupo4.hospitalupskill.consultas.appointment.Appointment;
import com.Bgrupo4.hospitalupskill.consultas.appointment.AppointmentCreationRequest;
import com.Bgrupo4.hospitalupskill.consultas.vaga.Vaga;
import com.Bgrupo4.hospitalupskill.user.doctor.Doctor;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UtenteService {

    private final static String USER_NOT_FOUND_MSG = "O utente %s não foi encontrado";

    @Autowired
    private final UtenteRepository utenteRepository;

    public Optional<Utente> getUserById(Long id) {
        return utenteRepository.findById(id);
    }

    public List<Utente> getAllUtentes() {
        return utenteRepository.findAll();
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

    /*public void deleteUtente(Long id) {
        utenteRepository.deleteById(id);
    }*/
}
