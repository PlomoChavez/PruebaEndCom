package com.entrega;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class EntregableApplication implements CommandLineRunner {
	@Autowired
	private JdbcTemplate template;

	public static void main(String[] args) {
		SpringApplication.run(EntregableApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		template.execute("CREATE TABLE Pokemons (id VARCHAR(255), apodo VARCHAR(255), especie VARCHAR(255), tipo VARCHAR(255), ataque  VARCHAR(5), defensa VARCHAR(5), salud VARCHAR(5))");
	}

}
