package com.yangzg.crud.interceptor;

import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * Created by Sam on 2019/11/29.
 */
public class LocaleHandlerInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        final String uri = request.getRequestURI();
        final LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
        Locale locale = Locale.getDefault();
        if (uri.startsWith("/en")) {
            locale = Locale.ENGLISH;
        } else if (uri.startsWith("/zh")){
            locale = Locale.CHINESE;
        }
        localeResolver.setLocale(request, response, locale);
        return true;
    }
}
