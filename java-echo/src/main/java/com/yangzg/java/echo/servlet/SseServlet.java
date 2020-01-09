package com.yangzg.java.echo.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Sam on 2020/1/6.
 * @author Sam
 */
@WebServlet(value = "/sse")
public class SseServlet extends HttpServlet {
    private static final long serialVersionUID = -3702729224506454646L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/sse.jsp").forward(req, resp);
    }
}
