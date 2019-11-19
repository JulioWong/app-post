package com.wong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class CursoSpring1Application implements CommandLineRunner {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public static void main(String[] args) {
		SpringApplication.run(CursoSpring1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		jdbcTemplate.execute("INSERT INTO permiso (Nombre) VALUES ('Ejemplo2');");
	}

}
