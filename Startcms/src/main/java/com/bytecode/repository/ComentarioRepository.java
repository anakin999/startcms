package com.bytecode.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bytecode.model.Comentario;

@Repository
public class ComentarioRepository implements IComentario {
	
@Autowired
private JdbcTemplate jdbcTemplate;

@Override
public boolean save(Comentario Object) {
	try {
		String sql = String.format("insert into comentario(comentario, idpost, idusuario, respuesta)"
				+ " values('%s', '%d', '%d', '%d')", Object.getComentario(), Object.getIdpost()
				, Object.getIdUsuario(), Object.getRespuesta());
		jdbcTemplate.execute(sql);
		
	}		
	catch(Exception e) {
		return false;
	}
	
	return true;
}

@Override
public boolean update(Comentario Object) {
	if(Object.getIdComentario() > 0) {
		try {
		String sql = String.format("update comentario set comentario = '%s', idpost = '%d', idusuario='%d', respuesta='%d'"
				+ " where idcomentario = '%d'", Object.getComentario(), Object.getIdpost()
				, Object.getIdUsuario() , Object.getRespuesta());
		jdbcTemplate.execute(sql);
		}catch(Exception e) {
			return false;
		}
	}
	return true;
}

@Override
public List<Comentario> findAll(Pageable p) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public Comentario findById(int id) {
	// TODO Auto-generated method stub
	return null;
}

}
