package com.hiyzg.shop.controller;

import com.hiyzg.shop.model.Account;
import com.hiyzg.shop.model.User;
import com.hiyzg.shop.service.AccountService;
import com.hiyzg.shop.service.BookService;
import com.hiyzg.shop.service.UserService;
import com.hiyzg.shop.service.impl.AccountServiceImpl;
import com.hiyzg.shop.service.impl.BookServiceImpl;
import com.hiyzg.shop.service.impl.UserServiceImpl;
import com.hiyzg.shop.util.ShopCart;
import com.hiyzg.shop.util.ShopCartUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

/**
 * Created by Sam on 2019/10/17.
 */
@WebServlet(value = "/transact", name = "TransactionServlet")
public class TransactServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private AccountService accountService = new AccountServiceImpl();
    private UserService userService = new UserServiceImpl();
    private BookService bookService = new BookServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String no = req.getParameter("no");
        final String name = req.getParameter("name");
        if (no == null || "".equals(no.trim())) {
            req.setAttribute("error", "银行卡号不能为空");
        } else if (name == null || "".equals(name.trim())) {
            req.setAttribute("no", no);
            req.setAttribute("error", "户主姓名不能为空");
        } else {
            req.setAttribute("name", name);
            final Optional<Account> accountOptional = this.accountService.getByNo(no);
            if (!accountOptional.isPresent()) {
                req.setAttribute("error", "银行卡号不正确");
                req.getRequestDispatcher("/WEB-INF/pages/transaction/preview/index.jsp").forward(req, resp);
                return;
            } else {
                req.setAttribute("no", no);
            }
            final Optional<User> userOptional = this.userService.getByUsername(name);
            if (!userOptional.isPresent()) {
                req.setAttribute("error", "户主姓名不正确");
                req.getRequestDispatcher("/WEB-INF/pages/transaction/preview/index.jsp").forward(req, resp);
                return;
            } else {
                req.setAttribute("name", name);
            }
            final Account account = accountOptional.get();
            final User user = userOptional.get();
            final ShopCart shopCart = ShopCartUtil.getShopCart(req);
            this.bookService.transact(user, account, shopCart);
            resp.sendRedirect(req.getContextPath() + "/transaction/success");
            return;
        }

        req.getRequestDispatcher("/WEB-INF/pages/transaction/preview/index.jsp").forward(req, resp);
    }
}
