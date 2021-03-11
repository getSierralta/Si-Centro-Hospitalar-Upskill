package com.Bgrupo4.hospitalupskill.consultas.vaga;

import com.Bgrupo4.hospitalupskill.user.doctor.Doctor;
import com.Bgrupo4.hospitalupskill.user.doctor.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.util.*;

@Service
@RequiredArgsConstructor
public class VagaService {

    private final VagaRepository vagaRepository;
    private final DoctorRepository doctorRepository;


    public void createVagasNextMonth(){
        List<Doctor> doctors = doctorRepository.findAll();
        YearMonth yearMonthObject = YearMonth.of(LocalDate.now().getYear(), getNextMonth().ordinal());
        int daysInMonth = yearMonthObject.lengthOfMonth();
        for (Doctor doctor: doctors) {
            boolean flag = false;
            for (int i = 1; i <= daysInMonth; i++){
                if (i % 7 == 0 ) {
                    flag = true;
                    continue;
                }
                if (flag) {
                    flag = false;
                    continue;
                }
                for (int j = 8; j <= 18; j++){
                    if (j != 13){
                        String date = LocalDate.now().getYear()+"-"+getNextMonth().ordinal()+"-"+i;
                        String hour = j+":00";
                        vagaRepository.save(new Vaga(date, hour, doctor.getEspecialidade(), doctor));
                    }
                }
            }
        }
    }
    //Only for developing porpuses
    public void createVagasThisMonth(){
        List<Doctor> doctors = doctorRepository.findAll();
        YearMonth yearMonthObject = YearMonth.of(LocalDate.now().getYear(), LocalDate.now().getMonth().ordinal());
        int daysInMonth = yearMonthObject.lengthOfMonth();
        for (Doctor doctor: doctors) {
            boolean flag = false;
            for (int i = LocalDate.now().getDayOfMonth()+1; i <= daysInMonth; i++){
                if (i % 7 == 0 ) {
                    flag = true;
                    continue;
                }
                if (flag) {
                    flag = false;
                    continue;
                }
                for (int j = 8; j <= 18; j++){
                    if (j != 13){
                        String date = LocalDate.now().getYear()+"-"+LocalDate.now().getMonth().ordinal()+"-"+i;
                        String hour = j+":00";
                        vagaRepository.save(new Vaga(date, hour, doctor.getEspecialidade(), doctor));
                    }
                }
            }
        }
    }
    private Month getNextMonth(){
        boolean nextMonth = false;
        Month month = null;
        for (Month m: Month.values()) {
            if (nextMonth){
               month = m;
                System.out.println("-----------------------------------"+month.name());
               break;
            }else {
                if (m.name().equals(LocalDate.now().getMonth().name())){
                    nextMonth = true;
                }
                if (LocalDate.now().getMonth().name().equals("DECEMBER")){
                    return Month.JANUARY;
                }
            }
        }
        return month;
    }
}
