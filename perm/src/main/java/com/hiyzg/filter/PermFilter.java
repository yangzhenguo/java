package com.hiyzg.filter;

import com.hiyzg.exception.NoPermissionException;
import com.hiyzg.model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Sam on 2019/10/4.
 */
@WebFilter("/*")
public class PermFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            HttpServletRequest request = (HttpServletRequest) servletRequest;
            HttpServletResponse response = (HttpServletResponse) servletResponse;
            final String servletPath = request.getServletPath();
            final User user = (User)request.getSession().getAttribute("user");
            if (servletPath.startsWith("/pages")) {
                if (user != null) {
                    if (user.getAuthorities().stream().anyMatch(authority -> authority.getUrl().equals(servletPath))) {
                        filterChain.doFilter(request, response);
                    }
                }
                throw new NoPermissionException("没有权限");
            }
            filterChain.doFilter(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void destroy() {

    }
}
