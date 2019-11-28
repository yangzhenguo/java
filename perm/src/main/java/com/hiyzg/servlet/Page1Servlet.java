package com.hiyzg.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Sam on 2019/10/4.
 */
@WebServlet("/pages/url1")
public class Page1Servlet extends HttpServlet {
    private static final long serialVersionUID = 3001743763752486404L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/pages/url1.jsp").forward(req, resp);
    }
}
