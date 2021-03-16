package com.Bgrupo4.hospitalupskill.consultas.vaga;

import com.Bgrupo4.hospitalupskill.consultas.appointment.Appointment;
import com.Bgrupo4.hospitalupskill.user.doctor.Doctor;
import com.Bgrupo4.hospitalupskill.user.doctor.DoctorRepository;
import com.Bgrupo4.hospitalupskill.user.utente.Utente;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

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
                Calendar calendar = new GregorianCalendar(LocalDate.now().getYear(), getNextMonth().ordinal(),i);
                for (int j = 8; j <= 18; j++){
                    if (j != 13){
                       String time = j+":00";
                        vagaRepository.save(new Vaga(calendar, time, doctor.getEspecialidade(), doctor));
                    }
                }
            }
        }
    }
    //Only for developing purposes
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
                Calendar calendar = new GregorianCalendar(LocalDate.now().getYear(), LocalDate.now().getMonth().ordinal(), i);
                for (int j = 8; j < 17; j++){
                    if (j != 13){
                        String time = j+":00";
                        vagaRepository.save(new Vaga(calendar, time, doctor.getEspecialidade(), doctor));
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

    public List<Vaga> getVagas(String especialidade, String dia) {
        String[] split = dia.split("-");
        String[] m = split[1].split("");
        String[] d = split[2].split("");
        String month = m.length == 2 ? split[1] : "0"+split[1];
        String day = d.length == 2 ? split[2] : "0"+split[2];
        return vagaRepository.findAllByEspecialidadeAndDate(especialidade, new GregorianCalendar(Integer.parseInt(split[0]), Integer.parseInt(month), Integer.parseInt(day)));

    }

    public Vaga getOneVaga(String especialidade, String dia) {
        String[] split = dia.split("-");
        String[] m = split[1].split("");
        String[] d = split[2].split("");
        String month = m.length == 2 ? split[1] : "0"+split[1];
        String day = d.length == 2 ? split[2] : "0"+split[2];
        return vagaRepository.findFirstByEspecialidadeAndDate(especialidade, new GregorianCalendar(Integer.parseInt(split[0]), Integer.parseInt(month), Integer.parseInt(day)));
    }


}
