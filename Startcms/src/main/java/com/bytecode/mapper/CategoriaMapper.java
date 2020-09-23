package com.bytecode.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bytecode.model.Categoria;

public class CategoriaMapper implements RowMapper<Categoria> {

	@Override
	public Categoria mapRow(ResultSet rs, int rowNum) throws SQLException {
		Categoria categoria = new Categoria();
		categoria.setCategoriaSuperior(rs.getInt("categoriaSuperior"));
		categoria.setDescripcion(rs.getString("descripcion"));
		categoria.setFecha(rs.getDate("fecha"));
		categoria.setIdCategoria(rs.getInt("idCategoria"));
		categoria.setNombre(rs.getString("nombre"));
		return categoria;
	}

}
