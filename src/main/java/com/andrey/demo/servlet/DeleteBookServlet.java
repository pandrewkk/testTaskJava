package com.andrey.demo.servlet;

import com.andrey.demo.service.BookService;
import com.andrey.demo.service.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteBookServlet extends HttpServlet {
    private final BookService bookService = BookServiceImpl.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        try {
            long id = Long.parseLong(req.getParameter("id"));
            bookService.delete(id);

            resp.sendRedirect(req.getContextPath() + "/");
        } catch (RuntimeException e) {
            req.setAttribute("errorMessage", e.getMessage());
            req.getRequestDispatcher("/WEB-INF/error.jsp").forward(req, resp);
        }
    }
}
