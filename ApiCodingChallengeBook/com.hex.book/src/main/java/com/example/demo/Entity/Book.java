package com.example.demo.Entity;



import java.time.LocalDate;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long bookId;
	 @NotEmpty(message = "Title cannot be empty")
	    @Size(min = 1, max = 100, message = "Title must be between 1 and 100 characters")
	    private String title;

	    @NotEmpty(message = "Author cannot be empty")
	    @Size(min = 1, max = 100, message = "Author must be between 1 and 100 characters")
	    private String author;

	    @NotEmpty(message = "ISBN cannot be empty")
	    @Pattern(regexp = "\\d{13}", message = "ISBN must be a 13-digit number")
	    private String isbn;

	    @NotNull(message = "Publication Year cannot be null")
	    @Positive(message = "Publication Year must be a positive number")
	    private Integer publicationYear;

	
	public Book()
	{
		
	}


	public long getBookId() {
		return bookId;
	}


	public void setBookId(long bookId) {
		this.bookId = bookId;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public String getIsbn() {
		return isbn;
	}


	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}


	public Integer getPublicationYear() {
		return publicationYear;
	}


	public void setPublicationYear(Integer publicationYear) {
		this.publicationYear = publicationYear;
	}


	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", title=" + title + ", author=" + author + ", isbn=" + isbn
				+ ", publicationYear=" + publicationYear + "]";
	}


	public Book(long bookId,
			@NotEmpty(message = "Title cannot be empty") @Size(min = 1, max = 100, message = "Title must be between 1 and 100 characters") String title,
			@NotEmpty(message = "Author cannot be empty") @Size(min = 1, max = 100, message = "Author must be between 1 and 100 characters") String author,
			@NotEmpty(message = "ISBN cannot be empty") @Pattern(regexp = "\\d{13}", message = "ISBN must be a 13-digit number") String isbn,
			@NotNull(message = "Publication Year cannot be null") @Positive(message = "Publication Year must be a positive number") Integer publicationYear) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.publicationYear = publicationYear;
	}

	

}
