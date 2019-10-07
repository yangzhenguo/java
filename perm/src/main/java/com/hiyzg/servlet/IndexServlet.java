package com.hiyzg.servlet;

import com.hiyzg.exception.NoPermissionException;
import com.hiyzg.model.Authority;
import com.hiyzg.model.User;
import com.hiyzg.service.AuthorityService;
import com.hiyzg.service.UserService;
import com.hiyzg.service.impl.AuthorityServiceImpl;
import com.hiyzg.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by Sam on 2019/9/30.
 */
@WebServlet("")
public class IndexServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    private AuthorityService authorityService = new AuthorityServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        final String method = req.getParameter("method");
//        try {
//            this.getClass().getDeclaredMethod(method, HttpServletRequest.class, HttpServletResponse.class).invoke(this, req, resp);
//        } catch (Exception e) {
//            e.printStackTrace();
//            req.getRequestDispatcher("/WEB-INF/pages/index.jsp").forward(req, resp);
//        }
        Object obj = null;
        System.out.println(obj.toString());
        if (1 == 1) throw new NoPermissionException("haha");
        final String id = req.getParameter("id");
        if (id != null) {
            final User user = this.userService.get(Integer.parseInt(id)).orElse(null);
            req.setAttribute("user", user);
            req.setAttribute("authorities", this.authorityService.getAll()
                    .stream()
                    .collect(
                            Collectors.toMap(
                                    authority -> authority,
                                    authority -> user.getAuthorities()
                                            .stream()
                                            .mapToInt(Authority::getId)
                                            .anyMatch(num -> num == authority.getId())
                            )
                    ));
        } else {
            req.setAttribute("users", this.userService.getAll());
        }
        req.getRequestDispatcher("/WEB-INF/pages/index.jsp").forward(req, resp);
    }

    public void select(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/pages/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String id = req.getParameter("id");
        final String[] authorityIds = req.getParameterValues("authorityId");
        this.authorityService.updateAuthorities(Integer.parseInt(id), Arrays.stream(authorityIds).mapToInt(Integer::valueOf).boxed().collect(Collectors.toList()));
        if (id != null) {
            this.userService.get(Integer.parseInt(id)).ifPresent(user -> {
                req.getSession().setAttribute("user", user);
                req.setAttribute("user", user);
            });
        } else {
            req.setAttribute("users", this.userService.getAll());
        }
        resp.sendRedirect(req.getContextPath() + "/");
    }

    private static final long serialVersionUID = 9030991115292114875L;
}
