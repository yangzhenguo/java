package com.hiyzg.shop.controller;

import com.hiyzg.shop.criteria.BookCriteria;
import com.hiyzg.shop.service.BookService;
import com.hiyzg.shop.service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Sam on 2019/10/14.
 */
@WebServlet("/books")
public class BookServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final int SIZE = 5;
    private BookService bookService = new BookServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String pageStr = req.getParameter("page");
        int page = 0;
        try {
            page = Integer.valueOf(pageStr);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        final BookCriteria criteria = new BookCriteria(page, SIZE);
        req.setAttribute("pager", this.bookService.listForPager(criteria));
        req.getRequestDispatcher("/WEB-INF/pages/home/index.jsp").forward(req, resp);
    }
}
