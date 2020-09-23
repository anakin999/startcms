package com.bytecode.model;

public class PostMetadata {
private long idPostmetadata;
private long idPost;
private String clave;
private String valor;
private String tipo;
public long getIdPostmetadata() {
	return idPostmetadata;
}
public void setIdPostmetadata(long idPostmetadata) {
	this.idPostmetadata = idPostmetadata;
}
public long getIdPost() {
	return idPost;
}
public void setIdPost(long idPost) {
	this.idPost = idPost;
}
public String getClave() {
	return clave;
}
public void setClave(String clave) {
	this.clave = clave;
}
public String getValor() {
	return valor;
}
public void setValor(String valor) {
	this.valor = valor;
}
public String getTipo() {
	return tipo;
}
public void setTipo(String tipo) {
	this.tipo = tipo;
}


}
