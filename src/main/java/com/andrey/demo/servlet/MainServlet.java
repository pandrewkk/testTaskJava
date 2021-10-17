package com.andrey.demo.servlet;

import com.andrey.demo.model.BookFields;
import com.andrey.demo.dao.BookDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MainServlet extends HttpServlet {
    private final BookFields bookFields = BookFields.withAll();
    private final BookDAO bookDAO = BookDAO.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("bookList", bookDAO.getAll());
        req.setAttribute("fields", bookFields);
        req.getRequestDispatcher("/WEB-INF/main.jsp").forward(req, resp);
    }
}
