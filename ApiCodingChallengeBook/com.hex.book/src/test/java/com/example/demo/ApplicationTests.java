package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.Dao.BookRepository;
import com.example.demo.Entity.Book;
import com.example.demo.Service.BookService;

@SpringBootTest
class ApplicationTests {
	@Autowired
	BookRepository 	bookRepository;
	@Autowired
	BookService bookService;

	@Test
	public void addBook()
	{
		Book b=new Book();
		b.setAuthor("HaryPoter");
		b.setBookId(20);
		b.setIsbn("1234567896785");
		b.setPublicationYear(2001);
		b.setTitle("moon");
		bookRepository.save(b);
	}
	@Test
	public void updateBook()
	{
		Book b=new Book();
	b.setAuthor("HaryPoter");
	b.setBookId(20);
	b.setIsbn("1234567896785");
	b.setPublicationYear(2001);
	b.setTitle("moon");

		
	
      bookService.updateBook(1, b);
      bookRepository.save(b);
}
	@Test
	public void deleteBook()
	{
		bookService.deleteBookByIsbn("8414030012509");
	}	
	@Test
	public void getBook()
	{
		bookService.getBook("8414030012509");
	}
	@Test
	public void getAllBook()
	{
		bookService.getAllBooks();
	}
}
	