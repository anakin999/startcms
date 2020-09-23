package com.bytecode.model;

import java.util.Date;

public class Categoria {
	
	private long idCategoria;
	private String nombre;
	private String descripcion;
	private Date fecha;
	private long categoriaSuperior;
	
	
	
	public long getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(long idCategoria) {
		this.idCategoria = idCategoria;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public long getCategoriaSuperior() {
		return categoriaSuperior;
	}
	public void setCategoriaSuperior(long categoriaSuperior) {
		this.categoriaSuperior = categoriaSuperior;
	}
	
	
	

}
