package com.Bgrupo4.hospitalupskill;

import com.Bgrupo4.hospitalupskill.consultas.ConsultasService;
import com.Bgrupo4.hospitalupskill.consultas.vaga.Vaga;
import com.Bgrupo4.hospitalupskill.user.ApplicationUserService;
import com.Bgrupo4.hospitalupskill.user.UserRole;
import com.Bgrupo4.hospitalupskill.user.employee.Employee;
import com.Bgrupo4.hospitalupskill.user.employee.Unidade;
import com.Bgrupo4.hospitalupskill.user.doctor.Doctor;
import com.Bgrupo4.hospitalupskill.user.doctor.Especialidade;
import com.Bgrupo4.hospitalupskill.user.utente.Utente;
import com.Bgrupo4.hospitalupskill.user.utente.UtenteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class HospitalUpskillApplication {

	public final static Unidade upskill =  new Unidade(121, "Upskill", "upskill@upskill.upskill", "Avenida Up n. Skill","Sintra", "456456665", "UpPhoto");
	public final static List<Especialidade> especialidades = Arrays.asList(Especialidade.GERAL, Especialidade.CARDIOLOGIA, Especialidade.FISIOTERAPIA, Especialidade.GINECOLOGIA, Especialidade.RADIOLOGIA);
	private final ApplicationUserService applicationUserService;
	private final ConsultasService consultasService;


	public static void main(String[] args) {
		SpringApplication.run(HospitalUpskillApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner() {
		return args -> {
			// FOR TESTING PURPOSES

			//USERS
			Utente utente = new Utente("2", "Joao", "utente", "utente@utente.com", "123", "Sintra","Lisboa","914789651","25-06-1998" ,"apolice", "123456789");
			applicationUserService.enableAndSave(utente);
			applicationUserService.enableAndSave(new Utente("8", "Juan", "utente1", "utente1@utente.com", "123", "El Cabo","Paraguana","914789651","25-06-1998" ,"apo", "123456789"));
			applicationUserService.enableAndSave(new Utente("9", "Jesus", "utente2", "utente2@utente.com", "123", "San Juan","Las Cumaraguas","914789651","25-06-1998" ,"lice", "123456789"));
			applicationUserService.enableAndSave(new Employee("1", "Max", "admin", "admin@admin.com", "123", UserRole.ADMIN.name(), upskill));
			Doctor doctor = new Doctor("3", "Thiago", "medico", "medico@medico.com", "123", UserRole.MEDICO.name(), upskill, "cedula", especialidades);
			applicationUserService.enableAndSave(doctor);
			applicationUserService.enableAndSave(new Employee("4", "Gabriel", "responsavel", "responsavel@responsavel.com", "123", UserRole.RESPONSAVEL.name(), upskill));
			applicationUserService.enableAndSave(new Employee("5", "Max", "colaborador", "colaborador@colaborador.com", "123", UserRole.COLABORADOR.name(), upskill));
			applicationUserService.enableAndSave(new Doctor("6", "Thiago", "medico_responsavel", "medico_responsavel@medico.com", "123", UserRole.MEDICO_RESPONSAVEL.name(), upskill, "cedula", especialidades));
			applicationUserService.enableAndSave(new Employee("7", "Joao", "colaborador_responsavel", "colaborador_responsavel@colaborador.com", "123", UserRole.COLABORADOR_RESPONSAVEL.name(), upskill));

			//Appointments
			Vaga vaga = new Vaga("2021-06-18", "14:30", Especialidade.CARDIOLOGIA.name(), doctor);
			Vaga vaga1 = new Vaga("2021-05-18", "16:30", Especialidade.CARDIOLOGIA.name(), doctor);
			Vaga vaga2 = new Vaga("2021-04-18", "15:30", Especialidade.CARDIOLOGIA.name(), doctor);
			Vaga vaga3 = new Vaga("2021-03-18", "13:30", Especialidade.CARDIOLOGIA.name(), doctor);
			consultasService.createVaga(vaga);
			consultasService.createAppointment(vaga, utente);
			consultasService.createAppointment(vaga1, utente);
			consultasService.createAppointment(vaga2, utente);
			consultasService.createAppointment(vaga3, utente);

		};
	}
}
