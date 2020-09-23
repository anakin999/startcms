package com.bytecode.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bytecode.model.Contenido;

@Repository
public class ContenidoRepository implements IContenido{
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean save(Contenido Object) {
		try {
			String sql = String.format("insert into contenido(tipo, contenido, idpost)"
					+ " values('%s', '%s', '%d')", Object.getTipo() , Object.getContenido()
					, Object.getIdPost());
			jdbcTemplate.execute(sql);
			
		}		
		catch(Exception e) {
			return false;
		}
		
		return true;
	}

	@Override
	public boolean update(Contenido Object) {
		if(Object.getIdContendo() > 0) {
			try {
			String sql = String.format("update contenido set tipo = '%s', contenido = '%s'"
					+ " where idcontenido = '%d'", Object.getTipo() , Object.getContenido()
					, Object.getIdContendo());
			jdbcTemplate.execute(sql);
			}catch(Exception e) {
				return false;
			}
		}
		return true;
	}

	@Override
	public List<Contenido> findAll(Pageable p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Contenido findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
