package com.hiyzg.shop.controller;

import com.hiyzg.shop.service.BookService;
import com.hiyzg.shop.service.impl.BookServiceImpl;
import com.hiyzg.shop.util.ShopCart;
import com.hiyzg.shop.util.ShopCartUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Sam on 2019/10/15.
 */
@WebServlet("/addToCart")
public class AddToCartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private BookService bookService = new BookServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String idStr = req.getParameter("id");
        long id;
        try {
            id = Integer.valueOf(idStr);
        } catch (NumberFormatException e) {
            throw new RuntimeException("参数错误");
        }

        final ShopCart shopCart = ShopCartUtil.getShopCart(req);
        this.bookService.addToCart(id, shopCart);

        resp.sendRedirect(req.getContextPath() + "/books");
    }
}
