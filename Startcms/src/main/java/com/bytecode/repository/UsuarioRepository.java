package com.bytecode.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bytecode.model.Usuario;

@Repository
public class UsuarioRepository implements IUsuario{
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean save(Usuario Object) {
		try {
			String sql = String.format("insert into usuario(nombre, apellido, contraseña, correo, idgrupo)"
					+ " values('%s', '%s', '%s',  '%s', '%d')", Object.getNombre(), Object.getApellido(), Object.getContraseña(),
					Object.getCorreo(), Object.getIdGrupo());
			jdbcTemplate.execute(sql);
			
		}		
		catch(Exception e) {
			return false;
		}
		
		return true;
	}

	@Override
	public boolean update(Usuario Object) {
		if(Object.getIdUsuario() != 0) {
			try {
			String sql = String.format("update usuario set nombre = '%s', apellido = '%s', contraseña='%s'"
					+ " correo = '%s', idgrupo='%d' where idusuario = '%d'", Object.getNombre(), Object.getApellido()
					, Object.getContraseña(), Object.getCorreo(), Object.getIdGrupo(), Object.getIdUsuario());
			jdbcTemplate.execute(sql);
			}catch(Exception e) {
				return false;
			}
		}
		return true;
	}

	@Override
	public List<Usuario> findAll(Pageable p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
