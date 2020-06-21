package com.test.app;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.test.app.controller.LibraryController;
import com.test.app.model.Book;
import com.test.app.model.Category;
import com.test.app.service.BookService;
import com.test.app.service.CategoryService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LibraryController.class)
public class LibraryControllerTest {

	@MockBean
	private CategoryService categoryService;

	@MockBean
	private BookService bookService;

	private List<Category> categoryList;

	private List<Book> bookList;

	@Before
	public void setMockOutput() {
		categoryList = new ArrayList<Category>();
		Category category1 = new Category();
		category1.setCategoryName("Science");
		category1.setId(1);

		Category category2 = new Category();
		category2.setCategoryName("Literature");
		category2.setId(2);
		categoryList.add(category1);
		categoryList.add(category2);

		bookList = new ArrayList<Book>();

		Book book = new Book();
		book.setAuthor_name("Ashok");
		book.setBook_name("Test Book 1");
		book.setCategoryId(1);

		Book book2 = new Book();
		book2.setAuthor_name("Bala");
		book2.setBook_name("Test Book 2");
		book2.setCategoryId(1);

		bookList.add(book);
		bookList.add(book2);

		when(categoryService.listAllCategories()).thenReturn(categoryList);
		when(bookService.listAllBooks()).thenReturn(bookList);
		when(bookService.findByCategory(1)).thenReturn(bookList);
	}

	@Test
	public void listAllCategories() {

		assertEquals(categoryService.listAllCategories(), categoryList);
	}

	@Test
	public void listAllBooks() {
		assertEquals(bookService.listAllBooks(), bookList);
	}
	
	@Test
	public void listNoBooks() {
		when(bookService.listAllBooks()).thenReturn(new ArrayList<Book>());
		assertEquals(bookService.listAllBooks(), new ArrayList<Book>());
	}
	
	@Test
	public void listByCategory(){
		assertEquals(bookService.findByCategory(1), bookList);

	}
}
