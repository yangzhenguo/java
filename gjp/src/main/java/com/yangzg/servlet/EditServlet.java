package com.yangzg.servlet;

import com.yangzg.model.Account;
import com.yangzg.service.impl.AccountServiceImpl;
import com.yangzg.service.inf.AccountService;
import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by Sam on 2019/7/9.
 */
@WebServlet("/edit")
public class EditServlet extends HttpServlet {
    private static final long serialVersionUID = -3195672309345003262L;
    public static final Logger LOGGER = LoggerFactory.getLogger(EditServlet.class);
    private static final String ERROR_VIEW = "/WEB-INF/classes/views/error.jsp";
    private AccountService accountService = new AccountServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String view = "/WEB-INF/classes/views/edit.jsp";

        try {
            String idStr = req.getParameter("id");
            Integer id = new Integer(idStr);
            Optional<Account> accountOptional = this.accountService.getById(id);
            if (accountOptional.isPresent()) {
                req.setAttribute("account", accountOptional.get());
            } else {
                view = "/WEB-INF/classes/views/error.jsp";
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            LOGGER.error(e.toString());
            view = ERROR_VIEW;
        }
        req.getRequestDispatcher(view).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String> map = req.getParameterMap().entrySet().stream().collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue()[0]));

        Account bean = new Account();
        try {
            BeanUtils.populate(bean, new HashMap<String, Object>(){
                private static final long serialVersionUID = -6642885150594814441L;
                {
                    put("id", new Integer(req.getParameter("id")));
                    put("price", new Double(req.getParameter("price")));
                    put("category", req.getParameter("category"));
                    put("name", req.getParameter("name"));
                    put("description", req.getParameter("description"));
                }
            });
            System.out.println(bean);
            this.accountService.edit(bean);
            resp.sendRedirect("/");
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            req.getRequestDispatcher(ERROR_VIEW).forward(req, resp);
        }
    }
}
