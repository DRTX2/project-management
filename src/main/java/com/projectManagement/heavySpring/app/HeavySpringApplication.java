package com.projectManagement.heavySpring.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {
		"com.projectManagement.heavySpring.app",
		"com.projectManagement.heavySpring.adapters",
		"com.projectManagement.heavySpring.core"
})
@EnableJpaRepositories(basePackages = "com.projectManagement.heavySpring.adapters.persistence")
@EntityScan(basePackages = "com.projectManagement.heavySpring.adapters.persistence")
// Le indica a Spring dónde encontrar las clases @Entity que representan las tablas de la base de datos.
public class HeavySpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(HeavySpringApplication.class, args);
	}

}
