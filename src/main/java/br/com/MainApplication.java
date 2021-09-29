package br.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = { "br.com.model.entities" })
@ComponentScan(basePackages = { "br.com.controllers", "br.com.test.controllers.repository" }) // Não esquecer de tirar
																								// os
// repositórios de teste na hora de
// subir a aplicação online.
@EnableJpaRepositories(basePackages = { "br.com.repository" })
public class MainApplication {

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}

}