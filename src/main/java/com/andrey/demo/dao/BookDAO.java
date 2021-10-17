package com.andrey.demo.dao;

import com.andrey.demo.model.Book;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    public static final String URL = "jdbc:postgresql://localhost:5432/books_data";
    public static final String USER = "postgres";
    public static final String PASSWORD = "*";

    private static BookDAO instance;

    private Connection connection;

    private BookDAO() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static BookDAO getInstance() {
        if (instance == null) instance = new BookDAO();
        return instance;
    }

    public List<Book> getAll() {
        try {
            Statement statement = connection.createStatement();
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
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public Book getById(long id) {
        try {
            PreparedStatement statement = connection.prepareStatement("select * from books where id = ?");
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (!resultSet.next()) return null;
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
            e.printStackTrace();
            return null;
        }
    }

    public void add(Book book) {
        try {
            PreparedStatement statement = connection.prepareStatement("insert into books(author, title, genre, cover, year, description) values (?, ?, ?, ?, ?, ?)");
            statement.setString(1, book.getAuthor());
            statement.setString(2, book.getTitle());
            statement.setString(3, book.getGenre());
            statement.setString(4, book.getCoverUrl().toString());
            statement.setInt(5, book.getYear());
            statement.setString(6, book.getDescription());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(long id) {
        try {
            PreparedStatement statement = connection.prepareStatement("delete from books where id = ?");
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
