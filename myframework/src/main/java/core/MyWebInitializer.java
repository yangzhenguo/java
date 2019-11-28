package core;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * Created by Sam on 2019/9/19.
 */
public interface MyWebInitializer {
    void onStartup(ServletContext servletContext) throws ServletException;
}
