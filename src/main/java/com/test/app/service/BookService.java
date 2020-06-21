package com.test.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.test.app.model.Book;

@Service
public interface BookService {
	
	public List<Book> listAllBooks();
	public List<Book> findByCategory(long categoryId);
	public String updateBook(Book newBook);
	
}
