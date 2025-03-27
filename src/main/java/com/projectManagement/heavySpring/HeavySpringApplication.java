package com.projectManagement.heavySpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.projectManagement.heavySpring.adapters.persistence")
// Habilita el uso de repositorios JPA dentro del paquete especificado y permite que Spring cree automáticamente las implementaciones de esos repositorios.
@EntityScan(basePackages = "com.projectManagement.heavySpring.adapters.persistence")
// Le indica a Spring dónde encontrar las clases @Entity que representan las tablas de la base de datos.
public class HeavySpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(HeavySpringApplication.class, args);
	}

}
