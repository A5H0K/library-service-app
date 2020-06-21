package com.test.app.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.test.app.model.Book;

public interface BookRepository extends CrudRepository<Book, Long>{
	
	public List<Book> findAll();
	
	public List<Book> findByCategoryId(long categoryId);
	
	public Book findById(long bookId);
}
