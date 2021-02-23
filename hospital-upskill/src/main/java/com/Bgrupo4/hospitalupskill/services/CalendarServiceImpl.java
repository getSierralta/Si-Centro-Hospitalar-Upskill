package com.Bgrupo4.hospitalupskill.services;
import com.Bgrupo4.hospitalupskill.domain.Marcacao;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.*;

@Service
public class CalendarServiceImpl implements  CalendarService{

    List<Marcacao> marcacoes =  Arrays.asList(
            new Marcacao(new Date(2020,Calendar.FEBRUARY, 1)),
            new Marcacao(new Date(2020,Calendar.FEBRUARY, 2)),
            new Marcacao(new Date(2020,Calendar.FEBRUARY, 3)),
            new Marcacao(new Date(2020,Calendar.FEBRUARY, 4)));

    @Override
    public List<Marcacao> getMarcacoes() {
        marcacoes.sort(Comparator.comparing(Marcacao::getData));
        return marcacoes;
    }
}
