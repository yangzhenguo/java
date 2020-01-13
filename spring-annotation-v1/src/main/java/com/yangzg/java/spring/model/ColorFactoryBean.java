package com.yangzg.java.spring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.core.io.ClassPathResource;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

/**
 * Created by Sam on 2020/1/12.
 * @author Sam
 */
public class ColorFactoryBean implements FactoryBean<ColorFactoryBean.Color> {
    @Override
    public Color getObject() throws Exception {
        final ClassPathResource resource = new ClassPathResource("log4j.properties");
        resource.getInputStream();
        return new Color(new BufferedReader(new InputStreamReader(resource.getInputStream())).lines().collect(Collectors.joining("\n")));
    }

    @Override
    public Class<?> getObjectType() {
        return Color.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Color {
        String name;
    }
}
