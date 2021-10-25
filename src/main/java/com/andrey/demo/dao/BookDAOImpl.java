package com.andrey.demo.dao;

import com.andrey.demo.exception.BookNotFoundException;
import com.andrey.demo.exception.DatabaseException;
import com.andrey.demo.exception.InitializationException;
import com.andrey.demo.model.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAOImpl implements BookDAO {
    private static final Logger log = LoggerFactory.getLogger(BookDAOImpl.class);

    public static final String URL = "jdbc:postgresql://localhost:5432/books_data";
    public static final String USER = "postgres";
    public static final String PASSWORD = "*";

    private static BookDAOImpl instance;

    private final Connection connection;

    private BookDAOImpl() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new InitializationException("Ошибка инициализации BookDAO: класс драйвера не найден");
        } catch (SQLException e) {
            throw new InitializationException("Ошибка инициализации BookDAO");
        }
    }

    public static BookDAOImpl getInstance() {
        if (instance == null) instance = new BookDAOImpl();
        return instance;
    }

    @Override
    public List<Book> getAll() {
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("select * from books");
            ArrayList<Book> bookList = new ArrayList<>();
            while (resultSet.next()) {
                bookList.add(new Book(
                        resultSet.getLong("id"),
                        resultSet.getString("author"),
                        resultSet.getString("title"),
                        resultSet.getString("genre"),
                        new URL(resultSet.getString("cover")),
                        resultSet.getInt("year"),
                        resultSet.getString("description")
                ));
            }
            return bookList;
        } catch (SQLException | MalformedURLException e) {
            log.error("Cannot get books", e);
            throw new DatabaseException("Не удалось получить книги");
        }
    }

    @Override
    public Book getById(long id) {
        final String sql = "select * from books where id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (!resultSet.next()) throw new BookNotFoundException(id);
            return new Book(
                    resultSet.getLong("id"),
                    resultSet.getString("author"),
                    resultSet.getString("title"),
                    resultSet.getString("genre"),
                    new URL(resultSet.getString("cover")),
                    resultSet.getInt("year"),
                    resultSet.getString("description")
            );
        } catch (SQLException | MalformedURLException e) {
            log.error("Cannot get book by id", e);
            throw new DatabaseException("Не удалось получить книгу");
        }
    }

    @Override
    public void add(Book book) {
        final String sql = "insert into books(author, title, genre, cover, year, description) values (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, book.getAuthor());
            statement.setString(2, book.getTitle());
            statement.setString(3, book.getGenre());
            statement.setString(4, book.getCoverUrl().toString());
            statement.setInt(5, book.getYear());
            statement.setString(6, book.getDescription());
            statement.executeUpdate();
        } catch (SQLException e) {
            log.error("Cannot add book", e);
            throw new DatabaseException("Не удалось добавить книгу");
        }
    }

    @Override
    public void delete(long id) {
        final String sql = "delete from books where id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            log.error("Cannot delete book", e);
            throw new DatabaseException("Не удалось удалить книгу");
        }
    }
}
