package com.yangzg.servlet;

import com.yangzg.service.impl.AccountServiceImpl;
import com.yangzg.service.inf.AccountService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Sam on 2019/7/9.
 */
@WebServlet("/")
public class IndexServlet extends HttpServlet {
    private static final long serialVersionUID = -7017781164425770218L;
    private AccountService accountService = new AccountServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("accounts", this.accountService.listAll());
        req.getRequestDispatcher("/WEB-INF/classes/views/index.jsp").forward(req, resp);
    }
}
