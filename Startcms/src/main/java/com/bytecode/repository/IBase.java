package com.bytecode.repository;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;

public interface IBase<T> {
	
	public boolean save(T Object);
	public boolean update(T Object);
	public List<T> findAll(Pageable p);
	public T findById(int id);

}
