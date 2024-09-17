package com.example.demo.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
	

	Book findByIsbn(String isbn);
	@Modifying
    @Query("DELETE FROM Book b WHERE b.isbn = ?1")
    void deleteByIsbn(String isbn);

}
