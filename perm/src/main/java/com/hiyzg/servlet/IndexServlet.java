package com.hiyzg.servlet;

import com.hiyzg.service.UserService;
import com.hiyzg.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Sam on 2019/9/30.
 */
@WebServlet("")
public class IndexServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        final String method = req.getParameter("method");
//        try {
//            this.getClass().getDeclaredMethod(method, HttpServletRequest.class, HttpServletResponse.class).invoke(this, req, resp);
//        } catch (Exception e) {
//            e.printStackTrace();
//            req.getRequestDispatcher("/WEB-INF/pages/index.jsp").forward(req, resp);
//        }
        req.setAttribute("users", this.userService.getAll());
        req.getRequestDispatcher("/WEB-INF/pages/index.jsp").forward(req, resp);
    }

    public void select(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/pages/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String id = req.getParameter("id");
        if (id != null) {
            req.setAttribute("user", this.userService.get(Integer.parseInt(id)));
        } else {
            req.setAttribute("users", this.userService.getAll());
        }
        req.getRequestDispatcher("/WEB-INF/pages/index.jsp").forward(req, resp);
    }

    private static final long serialVersionUID = 9030991115292114875L;
}
