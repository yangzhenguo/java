package com.hiyzg.shop.controller;

import com.hiyzg.shop.service.BookService;
import com.hiyzg.shop.service.impl.BookServiceImpl;
import com.hiyzg.shop.util.ShopCartUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Sam on 2019/10/16.
 */
@WebServlet("/deleteFromCart")
public class DeleteFromCartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private BookService bookService = new BookServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String idStr = req.getParameter("id");
        int id;
        try {
            id = Integer.valueOf(idStr);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            throw new RuntimeException("参数错误");
        }
        this.bookService.deleteFromCart(id, ShopCartUtil.getShopCart(req));
        resp.sendRedirect(req.getContextPath() + "/cart");
    }
}
