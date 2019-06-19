package com.yangzg.chapter06;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by Sam on 2019/6/17.
 */
public class Person {
    private String name;
    private int age;

    public Person(final String name, final int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String toJson() {
        return Arrays.stream(this.getClass().getDeclaredMethods()).filter(method -> method.getName().startsWith("get")).map(this::doSomething).filter(str -> null != str && !str.isEmpty()).collect(Collectors.joining(",", "{", "}"));
    }

    private String doSomething(Method method) {
        try {
            String name = method.getName().substring(3, 4).toLowerCase() + method.getName().substring(4);
            if (method.isAnnotationPresent(Ignore.class)) {
                if (method.getAnnotation(Ignore.class).value()) {
                    return "";
                }
            }
            try {
                Field field = this.getClass().getDeclaredField(name);
                if (field.isAnnotationPresent(Ignore.class)) {
                    if (field.getAnnotation(Ignore.class).value()) {
                        return "";
                    }
                }
            } catch (NoSuchFieldException ignored) {}
            Object result = method.invoke(this);
            return String.format("\"%s\":%s", name, result instanceof CharSequence ? "\"" + result + "\"" : result);
        } catch (IllegalAccessException | InvocationTargetException ignored) {}
        return "";
    }

    public static void main(String[] args) {
        String json = new Person("sam young", 1).toJson();
        System.out.println(json);
    }
}

@Retention(RetentionPolicy.RUNTIME)
@Target({
        ElementType.METHOD,
        ElementType.FIELD
})
@interface Ignore {
    boolean value() default true;
}
