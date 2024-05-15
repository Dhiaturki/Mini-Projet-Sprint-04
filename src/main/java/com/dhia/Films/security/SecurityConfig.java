package com.dhia.Films.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import javax.sql.DataSource;


@Configuration
public class SecurityConfig {

	@Bean
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

		http.authorizeHttpRequests(
				(requests) -> requests.requestMatchers("/showCreate", "/saveProduit", "/modifierFilm", "/supprimerFilm")
						.hasAnyAuthority("ADMIN", "AGENT").requestMatchers("/modifierFilm", "/supprimerFilm")
						.hasAuthority("ADMIN").requestMatchers("/ListeProduits")
						.hasAnyAuthority("ADMIN", "AGENT", "USER")
						.requestMatchers("/login","/webjars/**").permitAll() 
						.anyRequest().authenticated())
				//.formLogin(Customizer.withDefaults()).httpBasic(Customizer.withDefaults())
		 .formLogin((formLogin) ->   formLogin 
                 .loginPage("/login") 
                 .defaultSuccessUrl("/") ) 
		.exceptionHandling((exception) -> exception.accessDeniedPage("/accessDenied"));
		return http.build();
	}

	
	/*@Bean
    public UserDetailsService userDetailsService(DataSource dataSource) {
		
		
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        jdbcUserDetailsManager.setUsersByUsernameQuery("SELECT username, password, enabled FROM user WHERE username = ?");

        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                "SELECT u.username, r.role AS authority " +
                        "FROM user_role ur " +
                        "INNER JOIN user u ON ur.user_id = u.user_id " +
                        "INNER JOIN role r ON ur.role_id = r.role_id " +
                        "WHERE u.username = ?");

        return jdbcUserDetailsManager;
    }*/
	
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	/*@Bean
	public InMemoryUserDetailsManager userDetailsService() {

		PasswordEncoder passwordEncoder = passwordEncoder (); 
		UserDetails user2 = User.withUsername("yazidi").password(passwordEncoder.encode("yazidi")).authorities("ADMIN")
				.build();
		UserDetails admin = User.withUsername("admin").password(passwordEncoder.encode("123")).authorities("ADMIN")
				.build();
		UserDetails userNadhem = User.withUsername("dhia").password(passwordEncoder.encode("123"))
				.authorities("AGENT", "USER").build();
		UserDetails user1 = User.withUsername("user1").password(passwordEncoder.encode("123")).authorities("USER")
				.build();

		return new InMemoryUserDetailsManager(admin, userNadhem, user1,user2);

	}
*/
}