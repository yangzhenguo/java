package com.yangzg.v2.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Created by Sam on 2019/11/6.
 */
public class ApplicationInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        final AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
        applicationContext.register(RootConfig.class);
        applicationContext.register(MvcConfig.class);
        applicationContext.setServletContext(servletContext);

        final ServletRegistration.Dynamic springMvc = servletContext.addServlet("springMvc", new DispatcherServlet(applicationContext));
        springMvc.addMapping("/");
        springMvc.setLoadOnStartup(1);
        springMvc.setAsyncSupported(true);
    }
}
