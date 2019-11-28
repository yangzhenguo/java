package com.yangzg.servlet.book;

import com.yangzg.model.book.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Sam on 2019/9/24.
 */
@WebServlet(name = "Step1Servlet", urlPatterns = "/book/step2")
public class Step2Servlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/pages/book/step2.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String cardType = request.getParameter("cardType");
        String card = request.getParameter("card");
        Customer customer = new Customer(name, address, cardType, card);
        request.getSession().setAttribute("customer", customer);
        response.sendRedirect(request.getContextPath() + "/book/step2");
    }
}
