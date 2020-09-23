package com.bytecode.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bytecode.model.Grupo;

@Repository
public class GrupoRepository implements IGrupo {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean save(Grupo Object) {
		try {
			String sql = String.format("insert into grupo(nombre)"
					+ " values('%s')", Object.getNombre());
			jdbcTemplate.execute(sql);
			
		}		
		catch(Exception e) {
			return false;
		}
		
		return true;
	}

	@Override
	public boolean update(Grupo Object) {
		if(Object.getIdGrupo() != 0) {
			try {
			String sql = String.format("update grupo set nombre = '%s'"
					+ " where idgrupo = '%d'", Object.getNombre(), Object.getIdGrupo());
			jdbcTemplate.execute(sql);
			}catch(Exception e) {
				return false;
			}
		}
		return true;
	}

	@Override
	public List<Grupo> findAll(Pageable p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Grupo findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
