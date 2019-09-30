package com.yangzg.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Sam on 2019/9/29.
 */
public abstract class HttpFilter implements Filter {
    public FilterConfig getFilterConfig() {
        return filterConfig;
    }

    private FilterConfig filterConfig;

    @Override
    public final void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
        this.init();
    }

    public void init() throws ServletException {

    }

    @Override
    public final void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            HttpServletRequest request = (HttpServletRequest)servletRequest;
            HttpServletResponse response = (HttpServletResponse)servletResponse;
            this.doFilter(request, response, filterChain);
        } catch (IOException | ServletException e) {
            e.printStackTrace();
            throw e;
        }
    }

    protected abstract void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException;

    @Override
    public void destroy() {

    }
}
