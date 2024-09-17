package com.example.demo.Exception;

public class BookAlreadyExistsException extends RuntimeException {
	
	public BookAlreadyExistsException(String message)
	{
		super(message);
	}
	public BookAlreadyExistsException()
	{
		super("Book with the provided isbn already exists");
	}
}