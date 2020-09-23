package com.bytecode.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bytecode.model.UsuarioMetadata;

@Repository
public class UsuarioMetadataRepository implements IUsuarioMetadata{
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean save(UsuarioMetadata Object) {
		try {
			String sql = String.format("insert into usuario_metadata(idusuario, clave, valor, tipo)"
					+ " values('%d', '%s', '%s', '%s')", Object.getIdUsuario(), Object.getClave()
					, Object.getValor(), Object.getTipo());
			jdbcTemplate.execute(sql);
			
		}		
		catch(Exception e) {
			return false;
		}
		
		return true;
	}

	@Override
	public boolean update(UsuarioMetadata Object) {
		if(Object.getUsuarioMetadata() != 0) {
			try {
			String sql = String.format("update usuario_metadata set idusuario = '%d', clave = '%s', valor='%s', tipo='%s'"
					+ " where idusuario_metadata = '%d'", Object.getIdUsuario(), Object.getClave()
					, Object.getValor(), Object.getTipo(), Object.getUsuarioMetadata());
			jdbcTemplate.execute(sql);
			}catch(Exception e) {
				return false;
			}
		}
		return true;
	}

	@Override
	public List<UsuarioMetadata> findAll(Pageable p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UsuarioMetadata findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
