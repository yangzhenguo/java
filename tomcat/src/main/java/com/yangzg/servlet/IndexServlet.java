package com.yangzg.servlet;

import com.yangzg.model.Person;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.getWriter().write("hello");
        Map<String, String> map = Collections.list(this.getInitParameterNames()).stream().collect(Collectors.toMap(key -> key, this::getInitParameter));
        System.out.println(map);

        List<Person> list = Stream.generate(() -> new Person((int) (Math.random() * 100), "yzg")).limit(10).collect(Collectors.toList());
        System.out.println(list);
        request.setAttribute("list", list);
        String json = list.stream().map(Person::toJSONString).collect(Collectors.joining(",", "[", "]"));
        request.setAttribute("json", json);
        request.getRequestDispatcher("/WEB-INF/pages/index.jsp").forward(request, response);
    }
}
