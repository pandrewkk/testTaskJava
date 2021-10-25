package com.andrey.demo.servlet;

import com.andrey.demo.model.Book;
import com.andrey.demo.service.BookService;
import com.andrey.demo.service.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URL;

public class AddBookServlet extends HttpServlet {
    private final BookService bookService = BookServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/addBook.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setCharacterEncoding("UTF-8");

            String title = req.getParameter("title");
            String author = req.getParameter("author");
            String genre = req.getParameter("genre");
            URL coverUrl = new URL(req.getParameter("coverUrl"));
            int year = Integer.parseInt(req.getParameter("year"));
            String description = req.getParameter("description");

            bookService.add(new Book(0, author, title, genre, coverUrl, year, description));

            resp.sendRedirect(req.getContextPath() + "/");
        } catch (RuntimeException e) {
            req.setAttribute("errorMessage", e.getMessage());
            req.getRequestDispatcher("/WEB-INF/error.jsp").forward(req, resp);
        }
    }
}
