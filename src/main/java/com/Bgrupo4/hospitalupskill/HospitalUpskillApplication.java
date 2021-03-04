package com.Bgrupo4.hospitalupskill;

import com.Bgrupo4.hospitalupskill.user.ApplicationUser;
import com.Bgrupo4.hospitalupskill.user.ApplicationUserRepository;
import com.Bgrupo4.hospitalupskill.user.ApplicationUserService;
import com.Bgrupo4.hospitalupskill.user.UserRole;
import com.Bgrupo4.hospitalupskill.user.employee.Employee;
import com.Bgrupo4.hospitalupskill.user.employee.Unidade;
import com.Bgrupo4.hospitalupskill.user.employee.doctor.Doctor;
import com.Bgrupo4.hospitalupskill.user.employee.doctor.Especialidade;
import org.springframework.beans.factory.annotation.Autowired;
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

	@Autowired
	public HospitalUpskillApplication(ApplicationUserService applicationUserService) {
		this.applicationUserService = applicationUserService;
	}

	public static void main(String[] args) {
		//Official branch asdfghjkl
		SpringApplication.run(HospitalUpskillApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(ApplicationUserRepository applicationUserRepository) {
		return args -> {
			// FOR TESTING PURPOSES ONLY

			//applicationUserService.enableAndSave(new Employee(123456789, "Shoshonka Petrokova", "petronka", "petronka@email.com","123", UserRole.COLABORADOR.name(),  upskill));
			//applicationUserService.enableAndSave(new Employee(123456228, "Reese Withoutherspoon", "respoon", "respoon@email.com","123", UserRole.COLABORADOR_RESPONSAVEL.name(),  upskill));
			//applicationUserService.enableAndSave(new Employee(123456789, "Juan", "juan", "juan@email.com","123", UserRole.COLABORADOR.name(),  upskill));
			//applicationUserService.enableAndSave(new Doctor(144456789, "Dr Love", "luv", "luv@email.com","123", UserRole.MEDICO.name(), upskill, "aasfghkjg", especialidades));
			//applicationUserService.enableAndSave(new Doctor(145645563, "Dr Jones", "bones", "bones@email.com","123", UserRole.MEDICO_RESPONSAVEL.name(), upskill, "cedula2", especialidades));
			applicationUserService.enableAndSave(new ApplicationUser(1, "Max", "admin", "admin@admin.com", "123", UserRole.ADMIN.name()));
			applicationUserService.enableAndSave(new ApplicationUser(2, "Joao", "utente", "utente@utente.com", "123", UserRole.UTENTE.name()));
			applicationUserService.enableAndSave(new ApplicationUser(3, "Thiago", "medico", "medico@medico.com", "123", UserRole.MEDICO.name()));
			applicationUserService.enableAndSave(new ApplicationUser(4, "Gabriel", "responsavel", "responsavel@responsavel.com", "123", UserRole.RESPONSAVEL.name()));
			applicationUserService.enableAndSave(new ApplicationUser(5, "Max", "colaborador", "colaborador@colaborador.com", "123", UserRole.COLABORADOR.name()));

		};
	}
}
