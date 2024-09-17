package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Book;
import com.example.demo.Service.BookService;

@RestController
@RequestMapping("/api") 
public class BookController {
    
    @Autowired
    private BookService bookService;

    @PostMapping("/admin/addBook")
    public ResponseEntity<Book> addBook(Book book) {
        Book b = bookService.addBook(book);
        return ResponseEntity.ok(b);
    }
    
    @PutMapping("/admin/updateBook/{bookId}")
    public ResponseEntity<String> updateBook(@PathVariable long bookId, Book book) {
        String b = bookService.updateBook(bookId, book);
        return ResponseEntity.ok(b);
    }
    
    @DeleteMapping("/admin/deleteBookByIsbn/{isbn}")
    public ResponseEntity<String> deleteBook(@PathVariable String isbn) {
        bookService.deleteBookByIsbn(isbn);
        return ResponseEntity.ok("Book deleted successfully");
    }
    
    @GetMapping("/user/getAllBooks")
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> list = bookService.getAllBooks();
        if (list.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(list);
        }
    }
    
    @GetMapping("/user/getBookByIsbn/{isbn}")
    public ResponseEntity<Book> getBook(@PathVariable String isbn) {
        Book b = bookService.getBook(isbn);
        return ResponseEntity.ok(b);
    }
}
