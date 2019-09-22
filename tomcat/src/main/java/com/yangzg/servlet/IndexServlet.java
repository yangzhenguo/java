package com.yangzg.servlet;

import com.yangzg.model.Product;
import com.yangzg.service.impl.ProductServiceImpl;
import com.yangzg.service.inf.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by Sam on 2019/9/18.
 */
@WebServlet(
        name = "IndexServlet",
        urlPatterns = "",
        displayName = "首页",
        description = "😆",
        initParams = {
                @WebInitParam(name = "name", value = "yzg", description = "test1"),
                @WebInitParam(name = "age", value = "23", description = "test2"),
        }
)
public class IndexServlet extends HttpServlet {
    private static final long serialVersionUID = -2631589392534662440L;
    private static final String INDEX_JSP = "/WEB-INF/pages/index.jsp";

    private static final File INDEX_JSP_FILE;

    private ProductService productService = new ProductServiceImpl();

    static {
        INDEX_JSP_FILE = Paths.get(IndexServlet.class.getClassLoader().getResource("/").getPath() + "/../../", INDEX_JSP).normalize().toFile();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> list = this.productService.listAll();
        request.setAttribute("products", list);
        request.setAttribute("json", list);
        request.getRequestDispatcher(INDEX_JSP).forward(request, response);
    }

    @Override
    protected long getLastModified(HttpServletRequest req) {
        return -1;
        // return INDEX_JSP_FILE.lastModified();
    }
}
