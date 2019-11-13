package com.yangzg.v2.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Created by Sam on 2019/11/6.
 */
public class ApplicationInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        final AnnotationConfigWebApplicationContext ac = new AnnotationConfigWebApplicationContext();
        ac.register(RootConfig.class, MvcConfig.class);

        final ServletRegistration.Dynamic springMvc = servletContext.addServlet("springMvc", new DispatcherServlet(ac));
        springMvc.addMapping("/");
        springMvc.setLoadOnStartup(1);

        final FilterRegistration.Dynamic filter = servletContext.addFilter("ff", new CharacterEncodingFilter());
        filter.addMappingForUrlPatterns(null, false, "/*");
    }
}
