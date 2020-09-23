package com.bytecode.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bytecode.model.GrupoPermiso;

@Repository
public class GrupoPermisoRepository implements IGrupoPermiso {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean save(GrupoPermiso Object) {
		try {
			String sql = String.format("insert into grupo_permiso(idgrupo, idpermiso,)"
					+ " values('%d', '%d')", Object.getIdGrupo(), Object.getIdPermsio());
			jdbcTemplate.execute(sql);
			
		}		
		catch(Exception e) {
			return false;
		}
		
		return true;
	}

	@Override
	public boolean update(GrupoPermiso Object) {
		
		return true;
	}

	@Override
	public List<GrupoPermiso> findAll(Pageable p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GrupoPermiso findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
