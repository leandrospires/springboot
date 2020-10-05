package com.example.mynotes.mynotes;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.mynotes.mynotes.models.Role;
import com.example.mynotes.mynotes.repositories.RoleRepository;

@SpringBootApplication
public class MynotesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MynotesApplication.class, args);
	}

	@Bean
	CommandLineRunner init(RoleRepository roleRepository) {
		return args -> {
			Role adminRole = roleRepository.findByRole("ADMIN");
			if (adminRole == null) {
				Role newAdminRole = new Role();
				newAdminRole.setRole("ADMIN");
				roleRepository.save(newAdminRole);
			}

			Role userRole = roleRepository.findByRole("USER");
			if (userRole == null) {
				Role newUserRole = new Role();
				newUserRole.setRole("USER");
				roleRepository.save(newUserRole);
			}
		};
	}
}
