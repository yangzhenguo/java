package com.yangzg.el;

import com.yangzg.beans3.Teacher;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

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
}
