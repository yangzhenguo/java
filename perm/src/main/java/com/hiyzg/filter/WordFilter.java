package com.hiyzg.filter;

import com.hiyzg.core.MyHttpServletRequest;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by Sam on 2019/10/7.
 */
@WebFilter("/*")
public class WordFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        final MyHttpServletRequest myHttpServletRequest = new MyHttpServletRequest((HttpServletRequest) servletRequest);
        filterChain.doFilter(myHttpServletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
