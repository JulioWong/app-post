package com.wong.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.wong.model.Conexion;
import com.wong.model.Usuario;

@Component
public class CreandoConexion {
	@Bean(name = "beanUsuario")
	public Usuario getUsuario() {
		return new Usuario();
	}
	
	@Bean(name = "beanConexion")
	public Conexion getConexion() {
		Conexion conexion = new Conexion();
		conexion.setDb("mysql");
		conexion.setUrl("localhost");
		return conexion;
	}
}
