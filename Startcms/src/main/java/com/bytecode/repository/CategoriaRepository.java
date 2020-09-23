package com.bytecode.repository;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Repository;

import com.bytecode.mapper.CategoriaMapper;
import com.bytecode.model.Categoria;

//@Repository
public class CategoriaRepository implements ICategoria {
	
	@Autowired
	private DataSource dataSource;
	
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@PostConstruct
	public void postConstruct() {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public boolean save(Categoria categoria) {
		try {
			String sql = String.format("insert into categoria(nombre, descripcion)"
					+ " values('%s', '%s')", categoria.getNombre(), categoria.getDescripcion());
			jdbcTemplate.execute(sql);
			
		}		
		catch(Exception e) {
			return false;
		}
		
		return true;
	}

	@Override
	public boolean update(Categoria categoria) {
		if(categoria.getIdCategoria() > 0) {
			try {
			String sql = String.format("update categoria set nombre = '%s', descripcion = '%s',"
					+ " categoriaSuperior='%d'"
					+ " where idcategoria = '%d'", categoria.getNombre(), categoria.getDescripcion()
					, categoria.getCategoriaSuperior(), categoria.getIdCategoria());
			jdbcTemplate.execute(sql);
			}catch(Exception e) {
				return false;
			}
		}
		return true;
	}

	@Override
	public List<Categoria> findAll(Pageable pageable) {
		return jdbcTemplate.query("select * from Categoria", new CategoriaMapper());
	}

	@Override
	public Categoria findById(int id) {
		Object[] params = new Object[] {id};
		return jdbcTemplate.queryForObject("select * from categoria where idcategoria = ?", params,
				new CategoriaMapper());
	}
	
	public void deleteAll() {
		jdbcTemplate.execute("delete from categoria");
	}

}
