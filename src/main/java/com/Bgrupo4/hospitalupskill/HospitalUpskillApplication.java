package com.Bgrupo4.hospitalupskill;

import com.Bgrupo4.hospitalupskill.user.ApplicationUserService;
import com.Bgrupo4.hospitalupskill.user.UserRole;
import com.Bgrupo4.hospitalupskill.user.employee.Employee;
import com.Bgrupo4.hospitalupskill.user.employee.Unidade;
import com.Bgrupo4.hospitalupskill.user.doctor.Doctor;
import com.Bgrupo4.hospitalupskill.user.doctor.Especialidade;
import com.Bgrupo4.hospitalupskill.user.utente.Utente;
import com.Bgrupo4.hospitalupskill.user.utente.UtenteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class HospitalUpskillApplication {

	public final static Unidade upskill =  new Unidade(121, "Upskill", "upskill@upskill.upskill", "Avenida Up n. Skill","Sintra", "456456665", "UpPhoto");
	public final static List<Especialidade> especialidades = Arrays.asList(Especialidade.Geral, Especialidade.Cardiologia, Especialidade.Fisioteratia, Especialidade.Ginecologia, Especialidade.Radiologia);
	private final ApplicationUserService applicationUserService;

	public HospitalUpskillApplication(ApplicationUserService applicationUserService) {
		this.applicationUserService = applicationUserService;
	}


	public static void main(String[] args) {
		SpringApplication.run(HospitalUpskillApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner() {
		return args -> {
			// FOR TESTING PURPOSES ONLY
			applicationUserService.enableAndSave(new Utente("2", "Joao", "utente", "utente@utente.com", "123", "Sintra","Lisboa","914789651","25-06-1998" ,"apolice", "123456789"));
			applicationUserService.enableAndSave(new Utente("8", "Juan", "utente1", "utente1@utente.com", "123", "El Cabo","Paraguana","914789651","25-06-1998" ,"apo", "123456789"));
			applicationUserService.enableAndSave(new Utente("9", "Jesus", "utente2", "utente2@utente.com", "123", "San Juan","Las Cumaraguas","914789651","25-06-1998" ,"lice", "123456789"));
			applicationUserService.enableAndSave(new Employee("1", "Max", "admin", "admin@admin.com", "123", UserRole.ADMIN.name(), upskill));
			applicationUserService.enableAndSave(new Doctor("3", "Thiago", "medico", "medico@medico.com", "123", UserRole.MEDICO.name(), upskill, "cedula", especialidades));
			applicationUserService.enableAndSave(new Employee("4", "Gabriel", "responsavel", "responsavel@responsavel.com", "123", UserRole.RESPONSAVEL.name(), upskill));
			applicationUserService.enableAndSave(new Employee("5", "Max", "colaborador", "colaborador@colaborador.com", "123", UserRole.COLABORADOR.name(), upskill));
			applicationUserService.enableAndSave(new Doctor("6", "Thiago", "medico_responsavel", "medico_responsavel@medico.com", "123", UserRole.MEDICO_RESPONSAVEL.name(), upskill, "cedula", especialidades));
			applicationUserService.enableAndSave(new Employee("7", "Joao", "colaborador_responsavel", "colaborador_responsavel@colaborador.com", "123", UserRole.COLABORADOR_RESPONSAVEL.name(), upskill));
		};
	}
}
