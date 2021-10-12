package com.andrey.demo.dao;

import com.andrey.demo.model.Book;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BookDAO {
    private static BookDAO instance;

    private final List<Book> bookList;
    private long id;

    private BookDAO() {
        this.bookList = new ArrayList<>();
        this.id = 0;
        try {
            add(
                    new Book(
                            "А. С. Пушкин",
                            "Сказка о рыбаке и рыбке",
                            "Сказка",
                            new URL("https://cdn.shopify.com/s/files/1/2467/0413/products/70a0df668cdfa35d19faa9116cf1b795_1024x1024.jpg?v=1612279058"),
                            1833,
                            "Произведение в стихах А.С. Пушкина, любимая детьми вот уже в течение двух веков. В ней повествуется о необычайной удаче простого рыбака, которой воспользовалась его жена. ")
            );
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public static BookDAO getInstance() {
        if (instance == null) instance = new BookDAO();
        return instance;
    }

    public List<Book> getAll() {
        return new ArrayList<>(bookList);
    }

    public Book getById(long id) {
        for (Book book : bookList) {
            if (id == book.getId()) {
               return book;
            }
        }
        throw new IllegalStateException("Book with id " + id + " not found");
    }

    public void add(Book book) {
        book.setId(id);
        id++;
        bookList.add(book);
    }

    public void delete(long id) {
        Iterator<Book> bookIterator = bookList.iterator();
        Book book;
        while (bookIterator.hasNext()) {
            book = bookIterator.next();
            if (book.getId() == id) {
                bookIterator.remove();
                return;
            }
        }
    }
}
