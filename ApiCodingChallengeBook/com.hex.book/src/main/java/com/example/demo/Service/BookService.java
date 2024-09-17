package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Dao.BookRepository;
import com.example.demo.Entity.Book;
import com.example.demo.Exception.BookAlreadyExistsException;
import com.example.demo.Exception.BookNotFoundException;

import jakarta.transaction.Transactional;

@Service
public class BookService {
	@Autowired
	BookRepository bookRepository;

	public Book addBook(Book book) {
		Book b= bookRepository.findByIsbn(book.getIsbn());
		if(b!=null)
		{
			throw new BookAlreadyExistsException("This Book already exists");
		}
		else
		{
			bookRepository.save(book);
			return book;
		}
		
	}

	

	public String updateBook(long bookId, Book book) {
	   Book b=bookRepository.findById(bookId).orElseThrow(()->new BookNotFoundException("Book with id"+ bookId+"not found"));
	   
	  b.setBookId(bookId);
	  b.setAuthor(book.getAuthor());
	  b.setIsbn(book.getIsbn());
	  b.setTitle(book.getTitle());
	  b.setPublicationYear(book.getPublicationYear());
	  bookRepository.save(b);
	  return "Book Updated Successfully";
	}


	 @Transactional
	 public void deleteBookByIsbn(String isbn) {
	        Book book = bookRepository.findByIsbn(isbn);
	        if (book == null) {
	            throw new BookNotFoundException("Book with ISBN " + isbn + " not found");
	        }
	        bookRepository.deleteByIsbn(isbn);
	    }
		 
		
	



	public List<Book> getAllBooks() {
		List<Book>list =bookRepository.findAll();
		return list;
	}



	public Book getBook(String isbn) {
		 Book b=bookRepository.findByIsbn(isbn);
		 if(b==null)
		 {
			 throw new BookNotFoundException("Book with id"+ isbn+"not found");
		 }
		 else
		 {
			 	return b;
		 }
	}

}
