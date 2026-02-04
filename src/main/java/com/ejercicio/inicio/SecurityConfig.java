package com.ejercicio.inicio;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

	
	private static String ROL_INVITADO="INVITADO";
	private static String ROL_OPERADOR="OPERADOR";
	private static String ROL_ADMIN="ADMIN";
	
	@Bean
	InMemoryUserDetailsManager userDetails() throws Exception{
		
		List<UserDetails> usuarios = List.of(
				User.withUsername("user1")
				.password("{noop}user1") 
				.roles(ROL_INVITADO)
				.build(),
				User.withUsername("user2")
				.password("{noop}user2") 
				.roles(ROL_OPERADOR)
				.build(),
				User.withUsername("user3")
				.password("{noop}user3") 
				.roles(ROL_ADMIN)
				.build(),
				User.withUsername("user4")
				.password("{noop}user4") 
				.roles(ROL_OPERADOR,ROL_ADMIN)
				.build()	);
				
		return new InMemoryUserDetailsManager(usuarios);		
		
	}
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

		http.csrf(cr->cr.disable())
			.authorizeHttpRequests(aut -> aut
					.requestMatchers(HttpMethod.POST, "altacurso").hasAnyRole(ROL_ADMIN)
					.requestMatchers(HttpMethod.DELETE, "/curso/**").hasAnyRole(ROL_ADMIN,ROL_OPERADOR)
					.requestMatchers(HttpMethod.PUT, "/curso/**").hasAnyRole(ROL_ADMIN,ROL_OPERADOR)
					.requestMatchers("listadocursos","buscarcurso").authenticated()
					.anyRequest().permitAll())
			.httpBasic(Customizer.withDefaults());
		
		return http.build();
		
	}
}
