package com.dhia.Films;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.dhia.Films.model.Films;
import com.dhia.Films.model.Role;
import com.dhia.Films.model.User;
import com.dhia.Films.service.FilmService;
import com.dhia.Films.service.UserService;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class FilmsApplication implements CommandLineRunner {

	@Autowired
	UserService userService;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	FilmService filmService;

	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;

	public static void main(String[] args) {
		SpringApplication.run(FilmsApplication.class, args);
	}

	/*@PostConstruct
	void init_users() {
		// ajouter les rôles
		userService.addRole(new Role(null, "ADMIN"));
		userService.addRole(new Role(null, "AGENT"));
		userService.addRole(new Role(null, "USER"));

		// ajouter les users
		userService.saveUser(new User(null, "admin", "123", true, null));
		userService.saveUser(new User(null, "dhia", "123", true, null));
		userService.saveUser(new User(null, "user1", "123", true, null));

		// ajouter les rôles aux users
		userService.addRoleToUser("admin", "ADMIN");

		userService.addRoleToUser("dhia", "USER");
		userService.addRoleToUser("dhia", "AGENT");

		userService.addRoleToUser("user1", "USER");
	}*/

	@Override
	public void run(String... args) throws Exception {
		repositoryRestConfiguration.exposeIdsFor(Films.class);
		System.out.println("Password Encoded BCRYPT :******************** ");

		System.out.println(passwordEncoder.encode("123"));
	}
}
