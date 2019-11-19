package com.wong;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class CursoSpring1Application implements CommandLineRunner {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Value("${cursospring.jdbc.import.ruta}")
	private String ruta;
	
	@Value("${cursospring.jdbc.import}")
	private String importar;
	
	public static void main(String[] args) {
		SpringApplication.run(CursoSpring1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// jdbcTemplate.execute("INSERT INTO permiso (Nombre) VALUES ('Ejemplo2');");
		
		if (importar.equalsIgnoreCase("true")) {
			Path path = Paths.get(ruta);
			
			Log log = LogFactory.getLog(getClass());
			
			log.info(getClass());
			
			try(BufferedReader bufferedReader = Files.newBufferedReader(path, Charset.forName("UTF-8"))){
				String line;
				
				while ((line = bufferedReader.readLine()) != null) {
					jdbcTemplate.execute(line);
				}
				
			} catch (IOException e) {
				
			}
			
			log.info("Tenemos esta cantidad de permisos: " + jdbcTemplate.queryForObject("select count(1) from permiso", Integer.class));
		}
	}
}
