package filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

/**
 * Created by Sam on 2019/6/27.
 */
@WebFilter("/*")
public class LogFilter implements Filter {
    private static final Logger LOGGER = LoggerFactory.getLogger(LogFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (servletRequest instanceof HttpServletRequest) {
            HttpServletRequest request = (HttpServletRequest) servletRequest;
            StringBuffer url = request.getRequestURL();
            String queryString = request.getQueryString();
            LOGGER.info("用户访问, url=[{}], params=[{}]", url, queryString);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
    }
}
