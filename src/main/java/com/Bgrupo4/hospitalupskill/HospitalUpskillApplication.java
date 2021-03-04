package com.Bgrupo4.hospitalupskill;

import com.Bgrupo4.hospitalupskill.user.User;
import com.Bgrupo4.hospitalupskill.user.UserRepository;
import com.Bgrupo4.hospitalupskill.user.UserRole;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

import static com.Bgrupo4.hospitalupskill.user.UserRole.USER;

@SpringBootApplication
public class HospitalUpskillApplication {

	public static void main(String[] args) {
		//Official branch asdfghjkl
		SpringApplication.run(HospitalUpskillApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(UserRepository userRepository) {
		return args -> {
			User manuel = new User(116, "manuel", "manuel@upskill.pt");
			userRepository.save(manuel);
		};
	}
}
