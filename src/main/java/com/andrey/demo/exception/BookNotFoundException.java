package com.andrey.demo.exception;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(long id) {
        super("Book with id=" + id + " not found");
    }
}
