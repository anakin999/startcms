package com.bytecode.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bytecode.model.Permiso;

@Repository
public class PermisoRepository implements IPermiso{
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean save(Permiso Object) {
		try {
			String sql = String.format("insert into permiso(nombre)"
					+ " values('%s')", Object.getNombre());
			jdbcTemplate.execute(sql);
			
		}		
		catch(Exception e) {
			return false;
		}
		
		return true;
	}

	@Override
	public boolean update(Permiso Object) {
		if(Object.getIdPermiso() != 0) {
			try {
			String sql = String.format("update permiso set nombre = '%s'"
					+ " where idpermiso = '%d'", Object.getNombre(), Object.getIdPermiso());
			jdbcTemplate.execute(sql);
			}catch(Exception e) {
				return false;
			}
		}
		return true;
	}

	@Override
	public List<Permiso> findAll(Pageable p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Permiso findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
