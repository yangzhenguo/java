package com.yangzg.servlet;

import com.yangzg.exception.UserException;
import com.yangzg.service.impl.UserServiceImpl;
import com.yangzg.service.inf.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Sam on 2019/9/20.
 */
@WebServlet(name = "loginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 5908521732913069125L;

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        try {
            this.userService.login(username, password);
            req.getRequestDispatcher("/WEB-INF/pages/index.jsp").forward(req, resp);
        } catch (UserException e) {
            e.printStackTrace();
            resp.sendRedirect(req.getContextPath() + "/login.jsp");
        }
    }
}
