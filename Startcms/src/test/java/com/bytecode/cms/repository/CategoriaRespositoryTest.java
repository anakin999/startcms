package com.bytecode.cms.repository;

//import java.util.Date;

import org.junit.Assert;
//import org.junit.Test;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.bytecode.component.TestDatabaseConfiguration;
import com.bytecode.model.Categoria;
import com.bytecode.repository.CategoriaRepository;



@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {TestDatabaseConfiguration.class})
public class CategoriaRespositoryTest {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private Categoria categoria;

	@Test
	public void testInsert() {
		
		categoria.setNombre("catTest");		
		categoria.setDescripcion("Ejemplo junit test");
		
		boolean result = categoriaRepository.save(categoria);
		Assert.assertTrue(result);
		
	}
}
