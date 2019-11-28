package com.yangzg.crud.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.CacheControl;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Sam on 2019/11/24.
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.yangzg.crud.controller")
public class ServletConfig extends WebMvcConfigurerAdapter {
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/classes/views/", ".jsp");
    }

    @Bean
    public ResourceBundleMessageSource messageSource() {
        final ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasenames("i18n", "validation");
        messageSource.setFallbackToSystemLocale(false);
        messageSource.setCacheSeconds((int) TimeUnit.MINUTES.toSeconds(5));
        return messageSource;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/static/**")
                .addResourceLocations("/WEB-INF/classes/static/")
                .setCacheControl(CacheControl.maxAge(1, TimeUnit.DAYS));
    }
/*
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        FastJsonHttpMessageConverter messageConverter = new FastJsonHttpMessageConverter();
        messageConverter.setFastJsonConfig(new FastJsonConfig() {
            {
                this.setSerializerFeatures(
                        SerializerFeature.QuoteFieldNames,
                        SerializerFeature.WriteNullNumberAsZero
                );
            }
        });
        messageConverter.setSupportedMediaTypes(new ArrayList<MediaType>(){
            private static final long serialVersionUID = 3018155751628619269L;
            {
                this.add(MediaType.APPLICATION_JSON_UTF8);
            }
        });
        converters.add(messageConverter);
    }
*/
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        FastJsonHttpMessageConverter messageConverter = new FastJsonHttpMessageConverter();
        messageConverter.setFastJsonConfig(new FastJsonConfig() {
            {
                this.setSerializerFeatures(
                        SerializerFeature.QuoteFieldNames,
                        SerializerFeature.WriteNullNumberAsZero
                );
            }
        });
        messageConverter.setSupportedMediaTypes(new ArrayList<MediaType>(){
            private static final long serialVersionUID = 3018155751628619269L;
            {
                this.add(MediaType.APPLICATION_JSON_UTF8);
            }
        });
        converters.add(0, messageConverter);
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
