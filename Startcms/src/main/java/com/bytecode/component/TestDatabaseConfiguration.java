package com.bytecode.component;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.bytecode.model.Categoria;
import com.bytecode.repository.CategoriaRepository;

@Configuration
public class TestDatabaseConfiguration {

	@Bean
	public DataSource getDataSource() {		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/testusuario?zeroDateTimeBehavior=convertToNull&serverTimezone=UTC");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		return dataSource;
		
	}
	
	@Bean
	public CategoriaRepository categoriaRepository() {
		return new CategoriaRepository();
	}
	
	@Bean
	public Categoria categoria() {
		return new Categoria();
	}
}
