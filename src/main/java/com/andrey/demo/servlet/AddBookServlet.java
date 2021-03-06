package com.andrey.demo.servlet;

import com.andrey.demo.dao.BookDAO;
import com.andrey.demo.model.Book;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URL;

public class AddBookServlet extends HttpServlet {
    private final BookDAO bookDAO = BookDAO.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/addBook.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String title = req.getParameter("title");
        String author = req.getParameter("author");
        String genre = req.getParameter("genre");
        URL coverUrl = new URL(req.getParameter("coverUrl"));
        int year = Integer.parseInt(req.getParameter("year"));
        String description = req.getParameter("description");

        bookDAO.add(new Book(0, author, title, genre, coverUrl, year, description));

        resp.sendRedirect(req.getContextPath() + "/");
    }
}
