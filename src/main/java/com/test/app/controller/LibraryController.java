package com.test.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.app.model.Book;
import com.test.app.model.Category;
import com.test.app.service.BookService;
import com.test.app.service.CategoryService;

@RestController
@RequestMapping("/library-app")
public class LibraryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private BookService bookService;

	
	@GetMapping("/health")
	public String health(){
		
		return "Success";
	}
	
	@GetMapping("/listAllCategories")
	@ResponseBody
	public List<Category> listAllCategories(){
		return categoryService.listAllCategories();
	}
	
	@GetMapping("/listAllBooks")
	public List<Book> listAllBooks(){
		return bookService.listAllBooks();
	}
	
	@GetMapping("/listByCategory")
	public List<Book> findByCategory(@RequestParam long categoryId){
		
		return bookService.findByCategory(categoryId);
	}
	
	@PutMapping("/updateBook")
	public String updateBook(@RequestBody Book newBook){
		return bookService.updateBook(newBook);
	}
}
