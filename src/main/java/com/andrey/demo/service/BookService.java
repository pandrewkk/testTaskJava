package com.andrey.demo.service;

import com.andrey.demo.model.Book;

import java.util.List;

public interface BookService {
    List<Book> getAll();

    Book getById(long id);

    void add(Book book);

    void delete(long id);
}
