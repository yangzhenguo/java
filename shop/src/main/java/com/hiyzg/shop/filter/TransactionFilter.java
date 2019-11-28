package com.hiyzg.shop.filter;

import com.hiyzg.shop.util.ConnectionContext;
import com.hiyzg.shop.util.DataSourceUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Sam on 2019/10/17.
 */
@WebFilter(servletNames = "TransactionServlet")
public class TransactionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try (final Connection connection = DataSourceUtil.getDataSource().getConnection()) {
            connection.setAutoCommit(false);
            ConnectionContext.getInstance().set(connection);
            filterChain.doFilter(servletRequest, servletResponse);
            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                final Connection connection = ConnectionContext.getInstance().get();
                if (connection != null) {
                    connection.rollback();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            throw new RuntimeException(e);
        } finally {
            ConnectionContext.getInstance().remove();
        }
    }

    @Override
    public void destroy() {

    }
}
