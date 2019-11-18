package com.wong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.wong.beans.PostComponent;
import com.wong.model.Conexion;
import com.wong.services.PostService;

@SpringBootApplication
public class CursoSpring1Application implements CommandLineRunner {
	@Autowired
	@Qualifier("beanConexion")
	private Conexion conexion;
	
	@Autowired
	public PostComponent PostComponent;
	
	@Autowired
	public PostService postService;
	
	public static void main(String[] args) {
		SpringApplication.run(CursoSpring1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		postService.validationId(PostComponent.getPost()).forEach(post -> {
						System.out.println(post.getTitulo());
					});
	}

}
