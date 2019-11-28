package com.yangzg.config;

import org.apache.struts2.dispatcher.filter.StrutsPrepareAndExecuteFilter;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.util.EnumSet;

/**
 * Created by Sam on 2019/11/4.
 */
public class ApplicationServletContainerInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        servletContext.addListener(ContextLoaderListener.class);
        servletContext.setInitParameter("contextClass", AnnotationConfigWebApplicationContext.class.getName());
        servletContext.setInitParameter("contextConfigLocation", ApplicationConfig.class.getName());
//        servletContext.setInitParameter("contextConfigLocation", "/META-INF/applicationContext.xml");

        final FilterRegistration.Dynamic struts2 = servletContext.addFilter("struts2", StrutsPrepareAndExecuteFilter.class);
        struts2.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), false, "/*");
    }
}
