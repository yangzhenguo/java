package com.yangzg.lesson7;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Optional;

/**
 * @author Sam
 * @date 2020/3/29 8:36 PM
 */
public class MyConditional implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        final String os = context.getEnvironment().getProperty("os.name");
        return Optional.ofNullable(os).filter(str -> str.contains("Mac")).isPresent();
    }
}
