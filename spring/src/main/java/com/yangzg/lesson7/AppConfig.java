package com.yangzg.lesson7;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;

import java.util.Arrays;

/**
 * @author Sam
 * @date 2020/3/29 2:42 PM
 */
@Configuration
@ComponentScan(
        value = "com.yangzg.lesson7",
        includeFilters = @ComponentScan.Filter(
                type = FilterType.CUSTOM,
                value = MyTypeFilter.class
        ),
        useDefaultFilters = false
)
@Import({Book.class, Person.class})
public class AppConfig {
    @Bean
    @Lazy
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    @Conditional(MyConditional.class)
    public BookFactoryBean bookFactoryBean() {
        return new BookFactoryBean();
    }

    public static void main(String[] args) {
        try (final AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class)) {
            System.out.println(Arrays.toString(ac.getBeanDefinitionNames()));
            final Book book1 = ac.getBean("bookFactoryBean", Book.class);
            final Book book2 = ac.getBean("bookFactoryBean", Book.class);
            System.out.println(book1 == book2);
        }
    }
}
