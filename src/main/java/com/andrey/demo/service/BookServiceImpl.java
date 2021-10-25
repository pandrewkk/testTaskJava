package com.andrey.demo.service;

import com.andrey.demo.dao.BookDAO;
import com.andrey.demo.dao.BookDAOImpl;
import com.andrey.demo.model.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class BookServiceImpl implements BookService {
    private static final Logger log = LoggerFactory.getLogger(BookServiceImpl.class);

    private static BookServiceImpl instance;

    private final BookDAO bookDAO = BookDAOImpl.getInstance();

    public static BookServiceImpl getInstance() {
        if (instance == null) instance = new BookServiceImpl();
        return instance;
    }

    @Override
    public List<Book> getAll() {
        return bookDAO.getAll();
    }

    @Override
    public Book getById(long id) {
        return bookDAO.getById(id);
    }

    @Override
    public void add(Book book) {
        bookDAO.add(book);
        log.info("Book was added: {}", book);
    }

    @Override
    public void delete(long id) {
        bookDAO.delete(id);
        log.info("Book with id={} was deleted", id);
    }
}
