package com.hiyzg.shop.controller;

import com.hiyzg.shop.model.Book;
import com.hiyzg.shop.service.BookService;
import com.hiyzg.shop.service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

/**
 * Created by Sam on 2019/10/14.
 */
@WebServlet("/book/detail")
public class BookDetailServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private BookService bookService = new BookServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String idStr = req.getParameter("id");
        final int id;
        try {
            id = Integer.valueOf(idStr);
        } catch (NumberFormatException e) {
            throw new RuntimeException("参数传递错误");
        }
        final Optional<Book> bookOptional = this.bookService.getById(id);
        if (bookOptional.isPresent()) {
            req.setAttribute("book", bookOptional.get());
            req.getRequestDispatcher("/WEB-INF/pages/book/detail/index.jsp").forward(req, resp);
        } else {
            throw new RuntimeException("当前图书不存在");
        }
    }
}
