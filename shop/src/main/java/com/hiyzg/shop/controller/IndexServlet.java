package com.hiyzg.shop.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Sam on 2019/10/11.
 */
@WebServlet("")
public class IndexServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (1 == 1) throw new RuntimeException("error");
        req.getRequestDispatcher("/WEB-INF/pages/home/index.jsp").forward(req, resp);
    }
}
