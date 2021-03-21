package com.Bgrupo4.hospitalupskill.calendario;

import com.Bgrupo4.hospitalupskill.user.doctor.especialidade.Especialidade;
import com.Bgrupo4.hospitalupskill.user.doctor.especialidade.EspecialidadeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CalendarioService {

    private final EspecialidadeRepository especialidadeRepository;

    public List<String> getEspecialidades() {
        List<String> especialidades = new ArrayList<>();
        for (Especialidade es: especialidadeRepository.findAll()) {
            especialidades.add(es.getEspecialidade());
        }
        return especialidades;
    }
}
