package com.andrey.demo.servlet;

import com.andrey.demo.dao.BookDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteBookServlet extends HttpServlet {

    private final BookDAO bookDAO = BookDAO.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter("id"));
        bookDAO.delete(id);

        resp.sendRedirect(req.getContextPath() + "/");
    }
}
