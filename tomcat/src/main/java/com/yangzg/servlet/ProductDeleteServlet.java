package com.yangzg.servlet;

import com.yangzg.service.impl.ProductServiceImpl;
import com.yangzg.service.inf.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Sam on 2019/9/18.
 */
@WebServlet(
        name = "ProductDeleteServlet",
        urlPatterns = "/deleteProduct",
        displayName = "删除产品",
        description = "通过产品id来删除"
)
public class ProductDeleteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private ProductService productService = new ProductServiceImpl();


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            this.productService.remove(id);
            response.sendRedirect("/");
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
