package com.bytecode.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bytecode.model.Post;

@Repository
public class PostRepository implements IPost {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean save(Post Object) {
		try {
			String sql = String.format("insert into post(titulo, slug, extracto, categoria, imagenDestacada, tipo, idusuario)"
					+ " values('%s', '%s', '%s',  '%d', '%s', '%s'. '%d')", Object.getTitulo(), Object.getSlug(), Object.getExtracto(),
					Object.getCategoria(), Object.getImagenDestacada(), Object.getTipo(), Object.getIdUsuario());
			jdbcTemplate.execute(sql);
			
		}		
		catch(Exception e) {
			return false;
		}
		
		return true;
	}

	@Override
	public boolean update(Post Object) {
		if(Object.getIdPost() != 0) {
			try {
			String sql = String.format("update post set titulo = '%s', slug = '%s', extracto='%s', "
					+ "categoria='%d', imagenDestacada='%s', tipo='%s', idusuario='%d'"
					+ " where idpost = '%d'", Object.getTitulo(), Object.getSlug()
					, Object.getExtracto(), Object.getCategoria(), Object.getImagenDestacada(), Object.getTipo(), 
					  Object.getIdUsuario(), Object.getIdPost());
			jdbcTemplate.execute(sql);
			}catch(Exception e) {
				return false;
			}
		}
		return true;
	}

	@Override
	public List<Post> findAll(Pageable p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Post findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
