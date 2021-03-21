package com.Bgrupo4.hospitalupskill;

import com.Bgrupo4.hospitalupskill.calendario.CalendarioService;
import com.Bgrupo4.hospitalupskill.consultas.ConsultasService;
import com.Bgrupo4.hospitalupskill.consultas.appointment.Appointment;
import com.Bgrupo4.hospitalupskill.consultas.vaga.Vaga;
import com.Bgrupo4.hospitalupskill.senha.SenhaService;
import com.Bgrupo4.hospitalupskill.consultas.receitas.Receita;
import com.Bgrupo4.hospitalupskill.consultas.receitas.ReceitaService;
import com.Bgrupo4.hospitalupskill.consultas.vaga.VagaService;
import com.Bgrupo4.hospitalupskill.user.ApplicationUserService;
import com.Bgrupo4.hospitalupskill.user.UserRole;
import com.Bgrupo4.hospitalupskill.user.admin.Admin;
import com.Bgrupo4.hospitalupskill.user.doctor.DoctorService;
import com.Bgrupo4.hospitalupskill.user.employee.Employee;
import com.Bgrupo4.hospitalupskill.user.employee.Unidade;
import com.Bgrupo4.hospitalupskill.user.doctor.Doctor;
import com.Bgrupo4.hospitalupskill.user.doctor.especialidade.Especialidade;
import com.Bgrupo4.hospitalupskill.user.utente.Utente;
import com.Bgrupo4.hospitalupskill.user.utente.controllers.UtenteRestController;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.*;

@SpringBootApplication
@RequiredArgsConstructor
public class HospitalUpskillApplication {

    public final static Unidade upskill = new Unidade(121, "Upskill", "upskill@upskill.upskill", "Avenida Up n. Skill", "Sintra", "456456665", "UpPhoto");
    private final ApplicationUserService applicationUserService;
    private final ConsultasService consultasService;
    private final SenhaService senhaService;
    private final ReceitaService receitaService;
    private final VagaService vagaService;
    public static List<String> ECRA = new ArrayList<>();
    private final DoctorService doctorService;


    public static void main(String[] args) {
        SpringApplication.run(HospitalUpskillApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> {
            // FOR TESTING PURPOSES
            //USERS
            Especialidade osteopatia = doctorService.createEspecialidade("Osteopatia");
            Especialidade cardiologia = doctorService.createEspecialidade("Cardiologia");
            Especialidade oncologia = doctorService.createEspecialidade("Oncologia");
            Especialidade ginecologia = doctorService.createEspecialidade("Ginecologia");
            Especialidade radiologia = doctorService.createEspecialidade("Radiologia");
            Especialidade fisioterapia = doctorService.createEspecialidade("Fisioterapia");
            Especialidade geral = doctorService.createEspecialidade("geral");
            List<Utente> utentes = new ArrayList<>();
            Utente utente = new Utente("2", "Joao", "utente", "utente@utente.com", "123", "Sintra", "Lisboa", "914789651", new GregorianCalendar(1998, Calendar.JUNE, 10), "apolice", "123456789");
            utentes.add(applicationUserService.enableAndSave(utente));
            utentes.add(applicationUserService.enableAndSave(new Utente("18", "Juan", "utente1", "utente1@utente.com", "123", "El Cabo", "Paraguana", "914789651", new GregorianCalendar(1970, Calendar.JULY, 15), "apo", "123456789")));
            utentes.add(applicationUserService.enableAndSave(new Utente("19", "Jesus", "utente2", "utente2@utente.com", "123", "San Juan", "Las Cumaraguas", "914789651", new GregorianCalendar(1958, Calendar.FEBRUARY, 20), "lice", "123456789")));
            applicationUserService.enableAndSave(new Admin("1", "Max", "admin", "admin@admin.com", "123", "rua da joaquina", "Lisboa", "987654321", new GregorianCalendar(1958, Calendar.FEBRUARY, 20), UserRole.ADMIN.name()));
            applicationUserService.enableAndSave(new Admin("236", "José", "admin2", "admin2@admin.com", "123", "rua da joaquina", "Lisboa", "987654321", new GregorianCalendar(1958, Calendar.FEBRUARY, 20), UserRole.ADMIN.name()));
            List<Doctor> doctors = new ArrayList<>();
            Doctor doctor = new Doctor("3", "Thiago", "medico", "medico@medico.com", "123", "Sintra", "Lisboa", "914789651", new GregorianCalendar(1998, Calendar.JUNE, 10), "cedula", cardiologia, UserRole.MEDICO_RESPONSAVEL);
            doctors.add(applicationUserService.enableAndSave(doctor));
            applicationUserService.enableAndSave(new Employee("4", "Gabriel", "responsavel", "responsavel@responsavel.com", "123", "Sintra", "Lisboa", "914789651", new GregorianCalendar(1998, Calendar.JUNE, 10),UserRole.RESPONSAVEL.name()));
            applicationUserService.enableAndSave(new Employee("5", "Max", "colaborador", "colaborador@colaborador.com", "123", "Sintra", "Lisboa", "914789651", new GregorianCalendar(1998, Calendar.JUNE, 10), UserRole.COLABORADOR.name()));
            doctors.add(applicationUserService.enableAndSave(new Doctor("20", "Peter Baker", "medico1", "medico1@medico.com", "123", "Guaquira", "Pueblo Nuevo", "914789651", new GregorianCalendar(1998, Calendar.MARCH, 10), "cedula", oncologia,UserRole.MEDICO)));
            doctors.add(applicationUserService.enableAndSave(new Doctor("21", "Corgi Maguire", "medico2", "medico2@medico.com", "123", "Paraguana", "Falcon", "914789651", new GregorianCalendar(1998, Calendar.FEBRUARY, 10), "cedula", fisioterapia,UserRole.MEDICO)));
            doctors.add(applicationUserService.enableAndSave(new Doctor("22", "Jenipuur Lopez", "medico3", "medico3@medico.com", "123", "El Serro", "Santa Ana", "914789651", new GregorianCalendar(1998, Calendar.JULY, 10), "cedula", ginecologia,UserRole.MEDICO)));
            doctors.add(applicationUserService.enableAndSave(new Doctor("23", "David Meowie", "medico4", "medico4@medico.com", "123", "El Hato", "Pueblo Nuevo", "914789651", new GregorianCalendar(1998, Calendar.MARCH, 10), "cedula", radiologia,UserRole.MEDICO)));
            doctors.add(applicationUserService.enableAndSave(new Doctor("24", "Mitch Connor", "medico5", "medico5@medico.com", "123", "Adicora", "Paraguana", "914789651", new GregorianCalendar(1998, Calendar.DECEMBER, 10), "cedula", geral,UserRole.MEDICO)));
            doctors.add(applicationUserService.enableAndSave(new Doctor("25", "Mark Buffalo", "medico6", "medico6@medico.com", "123", "Piedras Negras", "Falcon", "914789651", new GregorianCalendar(1998, Calendar.JULY, 10), "cedula", osteopatia,UserRole.MEDICO)));
            doctors.add(applicationUserService.enableAndSave(new Doctor("6", "Thiago", "medico_responsavel", "medico_responsavel@medico.com", "123", "Sintra", "Lisboa", "914789651", new GregorianCalendar(1998, Calendar.JUNE, 10), "cedula", oncologia,UserRole.MEDICO)));
            applicationUserService.enableAndSave(new Employee("7", "Joao", "colaborador_responsavel", "colaborador_responsavel@colaborador.com", "123", "Sintra", "Lisboa", "914789651", new GregorianCalendar(1998, Calendar.JUNE, 10),UserRole.COLABORADOR_RESPONSAVEL.name()));

            //Appointments

            Vaga vaga = new Vaga(new GregorianCalendar(2021, Calendar.MARCH, 25, 14, 0,0), "14:00", cardiologia.getEspecialidade(), doctor);
            Vaga vaga1 = new Vaga(new GregorianCalendar(2021, Calendar.MARCH, Calendar.getInstance().getTime().getDate(), 16, 0, 0), "16:00", cardiologia.getEspecialidade(), doctor);
            Vaga vaga2 = new Vaga(new GregorianCalendar(2021, Calendar.MARCH, 17, 15, 0, 0), "15:00", cardiologia.getEspecialidade(), doctor);
            Vaga vaga3 = new Vaga(new GregorianCalendar(2021, Calendar.MARCH, 31, 15, 0, 0), "13:30", cardiologia.getEspecialidade(), doctor);
            Vaga vaga17 = new Vaga(new GregorianCalendar(2021, Calendar.MARCH, Calendar.getInstance().getTime().getDate(), 16, 0, 0), "16:00", cardiologia.getEspecialidade(), doctor);
            consultasService.createVaga(vaga);
            consultasService.createVaga(vaga1);
            consultasService.createVaga(vaga2);
            consultasService.createVaga(vaga3);
            Appointment appointment = consultasService.createAppointment(vaga1, utente);
            consultasService.createAppointment(vaga17, utente);
            consultasService.createAppointment(vaga, utente);
            Appointment appointment1 = consultasService.createAppointment(vaga2, utente);
            consultasService.cancelAppointment(appointment1.getId());

            Receita receita = receitaService.createReceita(appointment, "Ibuprofen 2 veces por dia."
                    +"\n Pokemon 1 vez por semana."
                    +"\n Doremon 2 colheres cada 8 horas."
                    +"\n Pandemonium cada vez que doe a cabeça.");

            vagaService.createVagasThisMonth();
            vagaService.createVagasNextMonth();

            for (int i = 8; i < 17; i++) {
                Utente utente1 = new Utente(String.valueOf(i), "Utente " + (i), "Utente" + (i), "Utente" + (i)+"@utente.com", "123", "Sintra", "Lisboa", "914789651", new GregorianCalendar(1998, Calendar.JUNE, 10), "apolice", "123456789");
                applicationUserService.enableAndSave(utente1);
                utentes.add(utente1);
                Vaga vaga8 = consultasService.createVaga(new Vaga(new GregorianCalendar(2021, Calendar.MARCH, Calendar.getInstance().getTime().getDate(), i, 0, 0 ), i+":00", cardiologia.getEspecialidade(), doctor));
                Appointment appointment2 = consultasService.createAppointment(vaga8, utente1);
                senhaService.createSenha(utente1);
                senhaService.createSenha(appointment2.getId());
            }

            List<Vaga> vagas = new ArrayList<>();
            for (Doctor doc: doctors) {
                for (int i = 1; i < 30; i++) {
                    Vaga v = new Vaga(new GregorianCalendar(2021, Calendar.MARCH, i, 14, 0,0), "14:00", doc.getEspecialidade().getEspecialidade(), doc);
                    vagas.add(consultasService.createVaga(v));
                    Vaga va = new Vaga(new GregorianCalendar(2021, Calendar.MARCH, i, 9, 0,0), "9:00", doc.getEspecialidade().getEspecialidade(), doc);
                    vagas.add(consultasService.createVaga(va));
                }
            }

            for (Vaga v: vagas) {
                Appointment a = consultasService.createAppointment(v, utentes.get(new Random().nextInt(12)));
                if (v.getDate().before(Calendar.getInstance())){
                    consultasService.cancelAppointment(a.getId());
                }
            }

        };
    }
}
