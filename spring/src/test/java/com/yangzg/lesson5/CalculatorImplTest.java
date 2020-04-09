package com.yangzg.lesson5;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Sam on 2020/3/22.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/lesson5/applicationContext.xml")
public class CalculatorImplTest {
    @Autowired
    @Lazy
    private Calculator calculator;

    @Test
    public void plus() throws Exception {
        this.calculator.plus(1, 3);
    }

    @Test
    public void minus() throws Exception {
        this.calculator.minus(5, 2);
    }

    @Test
    public void div() throws Exception {
        this.calculator.div(1, 0);
    }
}