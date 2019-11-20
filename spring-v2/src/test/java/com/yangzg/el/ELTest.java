package com.yangzg.el;

import com.yangzg.beans3.Teacher;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import java.util.Arrays;
import java.util.Date;

/**
 * Created by Sam on 2019/11/15.
 */
public class ELTest {
    @Test
    public void test1() {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans/el.xml")) {
            final String str1 = context.getBean("str1", String.class);
            System.out.println(str1);
        }
    }

    @Test
    public void test2() {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans/el.xml")) {
            ExpressionParser parser = new SpelExpressionParser();
            Expression exp = parser.parseExpression("'Hello World'");
            String message = (String) exp.getValue();
            System.out.println(message);
        }
    }

    @Test
    public void test3() {
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("'Hello World'");
        String message = (String) exp.getValue();
        System.out.println(message);

        parser.parseExpression("new com.yangzg.beans3.Teacher()").getValue(Teacher.class).say();

        System.out.println(parser.parseExpression("'abc'.bytes.length").getValue(Integer.class));
    }

    @Test
    public void test4() {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans/el.xml")) {
            final String str = context.getBean("str", String.class);
            System.out.println(str);
        }
    }

    @Test
    public void test5() {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans/el.xml")) {
            final SpelExpressionParser parser = new SpelExpressionParser();
            final Expression expression = parser.parseExpression("'Hello World'.concat('!')");
            final String value = expression.getValue(String.class);
            System.out.println(value);

            final byte[] bytes = parser.parseExpression("'Hello World'.bytes").getValue(byte[].class);
            System.out.println(Arrays.toString(bytes));

            System.out.println(parser.parseExpression("'abc'.bytes.length").getValue(int.class));

            System.out.println(parser.parseExpression("new String('abcde').length()").getValue(int.class));

            System.out.println(parser.parseExpression("time > 0").getValue(new Date(), boolean.class));

            System.out.println(parser.parseExpression("new java.util.Date(time + 1000 * 60 * 60 * 12)").getValue(new Date(), Date.class));

            System.out.println(context.getBean("str", String.class));
        }
    }

}
