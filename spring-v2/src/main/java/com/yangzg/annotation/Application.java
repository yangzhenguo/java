package com.yangzg.annotation;

import com.yangzg.beans3.Student;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.annotation.Order;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.core.env.Environment;
import org.springframework.format.support.DefaultFormattingConversionService;

import java.util.Map;
import java.util.Optional;
import java.util.Properties;

/**
 * Created by Sam on 2019/11/17.
 */
@Data
@Configuration
@PropertySource("classpath:beans/views.properties")
public class Application {
    @Autowired
    private Optional<String> stringOptional;

    @Autowired
    private Optional<ApplicationContext> applicationContextOptional;

    public Environment objects;

    @Bean
    @Order(1)
    @Primary
    public Properties properties() {
        final Properties properties = new Properties();
        properties.put("name", "yzg");
        return properties;
    }

    @Autowired
    public void setEnvironment(Environment environment) {
        this.objects = environment;
    }

    @Value("${file.encoding}")
    public String encoding;

    @Value("#{systemProperties}")
    public Map<String, String> sysProperties;

    @Value("#{systemEnvironment}")
    public Map<String, String> systemEnvironment;

    @Value("${PYENV_SHELL}")
    public String python;

    @Value("${java.runtime.name}")
    public String runtimeName;

    @Value("%[NAME:op,po]")
    public String[] name;

    @Value("%[jkj:kjghj]")
    public Student student;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        final PropertySourcesPlaceholderConfigurer placeholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        placeholderConfigurer.setValueSeparator(":");
        placeholderConfigurer.setPlaceholderPrefix("%[");
        placeholderConfigurer.setPlaceholderSuffix("]");
        return placeholderConfigurer;
    }

    @Bean
    public GenericConversionService conversionService() {
        final DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService();
        conversionService.addConverter(String.class, Student.class, Student::new);
        return conversionService;
    }
}
