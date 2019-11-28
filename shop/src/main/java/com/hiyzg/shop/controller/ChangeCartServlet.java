package com.hiyzg.shop.controller;

import com.google.gson.Gson;
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
import java.security.InvalidParameterException;
import java.text.NumberFormat;
import java.util.HashMap;

/**
 * Created by Sam on 2019/10/16.
 */
@WebServlet("/changeCart")
public class ChangeCartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private BookService bookService = new BookServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String idStr = req.getParameter("id");
        final String countStr = req.getParameter("count");
        resp.setContentType("application/json; charset=UTF-8");
        int id, count;
        try {
            id = Integer.valueOf(idStr);
            count = Integer.valueOf(countStr);
            if (id < 1 || count < 1) throw new InvalidParameterException();
        } catch (Exception e) {
            e.printStackTrace();
            final HashMap<String, Object> result = new HashMap<>();
            result.put("success", false);
            result.put("message", "参数错误");
            resp.getWriter().write(new Gson().toJson(result));
            return;
        }
        final ShopCart shopCart = ShopCartUtil.getShopCart(req);
        this.bookService.changeCart(id, count, shopCart);
        final HashMap<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("count", shopCart.getCount());
        final NumberFormat currencyInstance = NumberFormat.getCurrencyInstance();
        currencyInstance.setMaximumFractionDigits(2);
        final String price = currencyInstance.format(shopCart.getPrice());
        result.put("price", price);
        resp.getWriter().write(new Gson().toJson(result));
    }
}
