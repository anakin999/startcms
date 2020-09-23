package com.bytecode.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bytecode.model.PostMetadata;

@Repository
public class PostMetadataRepository implements IPostMetadata {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean save(PostMetadata Object) {
		try {
			String sql = String.format("insert into post_metadata(clave, valor, tipo, idpost)"
					+ " values('%s', '%s', '%s', '%d')", Object.getClave(), Object.getValor()
					, Object.getTipo(), Object.getIdPost() );
			jdbcTemplate.execute(sql);
			
		}		
		catch(Exception e) {
			return false;
		}
		
		return true;
	}

	@Override
	public boolean update(PostMetadata Object) {
		if(Object.getIdPostmetadata() != 0) {
			try {
			String sql = String.format("update post_metadata set nombre = '%s', descripcion = '%s', ObjectSuperior='%d'"
					+ " idpost='%d' where idpost_metadata = '%d'", Object.getClave(), Object.getValor()
					, Object.getTipo(), Object.getTipo(), Object.getIdPost(),  Object.getIdPostmetadata());
			jdbcTemplate.execute(sql);
			}catch(Exception e) {
				return false;
			}
		}
		return true;
	}

	@Override
	public List<PostMetadata> findAll(Pageable p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PostMetadata findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
