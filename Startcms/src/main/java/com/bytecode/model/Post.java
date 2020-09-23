package com.bytecode.model;

public class Post {
	private long idPost;
	private String titulo;
	private String slug;
	private String extracto;
	private long idUsuario;
	private long categoria;
	private String imagenDestacada;
	private String tipo;
	public long getIdPost() {
		return idPost;
	}
	public void setIdPost(long idPost) {
		this.idPost = idPost;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getSlug() {
		return slug;
	}
	public void setSlug(String slug) {
		this.slug = slug;
	}
	public String getExtracto() {
		return extracto;
	}
	public void setExtracto(String extracto) {
		this.extracto = extracto;
	}
	public long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public long getCategoria() {
		return categoria;
	}
	public void setCategoria(long categoria) {
		this.categoria = categoria;
	}
	public String getImagenDestacada() {
		return imagenDestacada;
	}
	public void setImagenDestacada(String imagenDestacada) {
		this.imagenDestacada = imagenDestacada;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	

}
