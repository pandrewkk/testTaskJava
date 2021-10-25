package com.andrey.demo.servlet;

import com.andrey.demo.service.BookService;
import com.andrey.demo.service.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DescriptionServlet extends HttpServlet {
    private final BookService bookService = BookServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            long id = Long.parseLong(req.getParameter("id"));
            req.setAttribute("book", bookService.getById(id));
            req.getRequestDispatcher("/WEB-INF/description.jsp").forward(req, resp);
        } catch (RuntimeException e) {
            req.setAttribute("errorMessage", e.getMessage());
            req.getRequestDispatcher("/WEB-INF/error.jsp").forward(req, resp);
        }
    }
}
