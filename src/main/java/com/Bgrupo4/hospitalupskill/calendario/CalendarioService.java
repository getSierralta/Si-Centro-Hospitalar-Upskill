package com.Bgrupo4.hospitalupskill.calendario;

import com.Bgrupo4.hospitalupskill.user.doctor.Especialidade;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CalendarioService {

    public List<String> getEspecialidades() {
        List<String> especialidades = new ArrayList<>();
        for (Especialidade es: Especialidade.values()) {
            especialidades.add(es.name());
        }
        return especialidades;
    }
}
