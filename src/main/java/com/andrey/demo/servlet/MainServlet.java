package com.andrey.demo.servlet;

import com.andrey.demo.model.BookFields;
import com.andrey.demo.service.BookService;
import com.andrey.demo.service.BookServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MainServlet extends HttpServlet {
    private final BookFields bookFields = BookFields.withAll();
    private final BookService bookService = BookServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setAttribute("bookList", bookService.getAll());
            req.setAttribute("fields", bookFields);
            req.getRequestDispatcher("/WEB-INF/main.jsp").forward(req, resp);
        } catch (RuntimeException e) {
            req.setAttribute("errorMessage", e.getMessage());
            req.getRequestDispatcher("/WEB-INF/error.jsp").forward(req, resp);
        }
    }
}
