package com.hiyzg.shop.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Sam on 2019/10/15.
 */
public class ShopCartUtil {
    private static final String KEY = "cart";

    public static ShopCart getShopCart(HttpSession session) {
        final Object attribute = session.getAttribute(KEY);
        if (attribute != null) {
            return (ShopCart)attribute;
        } else {
            final ShopCart shopCart = new ShopCart();
            session.setAttribute(KEY, shopCart);
            return shopCart;
        }
    }

    public static ShopCart getShopCart(HttpServletRequest request) {
        return ShopCartUtil.getShopCart(request.getSession());
    }
}
