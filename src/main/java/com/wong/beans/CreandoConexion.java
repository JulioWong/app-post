package com.wong.beans;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
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
	
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		datasource.setUrl("jdbc:mysql://localhost:3306/blog?useSSL=false");
		datasource.setUsername("administrator");
		datasource.setPassword("very_strong_password");
		return datasource;
	}
}
