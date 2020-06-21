package com.test.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.app.dao.BookRepository;
import com.test.app.model.Book;
import com.test.app.service.BookService;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	public List<Book> listAllBooks() {
		// TODO Auto-generated method stub
		return bookRepository.findAll();
	}

	public List<Book> findByCategory(long categoryId) {
		// TODO Auto-generated method stub
		return bookRepository.findByCategoryId(categoryId);
	}

	public String updateBook(Book newBook) {
		Book book = bookRepository.findById(newBook.getId());
		book.setCategoryId(newBook.getCategoryId());
		book.setBook_name(newBook.getBook_name());
		book.setAuthor_name(newBook.getAuthor_name());
		bookRepository.save(book);
		return "Book updated successfully!";
	}

}
