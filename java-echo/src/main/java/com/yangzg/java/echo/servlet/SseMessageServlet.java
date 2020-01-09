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
@WebServlet(value = "/sse/message")
public class SseMessageServlet extends HttpServlet {
    private static final long serialVersionUID = -3702729224506454646L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/event-stream;charset=UTF-8");
        resp.setHeader("Cache-Control", "no-cache");
        resp.setHeader("Connection", "keep-alive");
        resp.getWriter().write("data: 123\n\n");
        System.out.println("sending...");
        resp.getWriter().flush();
    }
}
