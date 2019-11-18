package com.wong.entitys;

import java.util.Date;

public class Post {
	private int id;
	private String descripcion;
	private String uriImg = "http://localhost:8080/img/test.jpeg";
	private Date fecha = new Date();
	private String titulo;
	
	public Post() {
		
	}
	
	public Post(int id, String descripcion, String uriImg, Date fecha, String titulo) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.uriImg = uriImg;
		this.fecha = fecha;
		this.titulo = titulo;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getUriImg() {
		return uriImg;
	}
	
	public void setUriImg(String uriImg) {
		this.uriImg = uriImg;
	}
	
	public Date getFecha() {
		return fecha;
	}
	
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
}
