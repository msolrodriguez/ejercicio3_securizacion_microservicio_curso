package com.ejercicio.inicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableJpaRepositories(basePackages="com.ejercicio.dao")
@EntityScan(basePackages="com.ejercicio.model")
@SpringBootApplication(scanBasePackages= {"com.ejercicio.inicio","com.ejercicio.controller", "com.ejercicio.service"})
public class Ejercicio3SecurizacionMicroservicioCursoApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ejercicio3SecurizacionMicroservicioCursoApplication.class, args);
	}

}
