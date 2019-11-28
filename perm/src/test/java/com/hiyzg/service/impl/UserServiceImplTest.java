package com.hiyzg.service.impl;

import com.hiyzg.model.User;
import com.hiyzg.service.UserService;
import org.junit.Test;

import java.text.MessageFormat;
import java.text.NumberFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;

import static org.junit.Assert.assertTrue;

/**
 * Created by Sam on 2019/10/1.
 */
public class UserServiceImplTest {
    private UserService userService = new UserServiceImpl();

    @Test
    public void get1() throws Exception {
        final Optional<User> userOptional = this.userService.get(1);
        userOptional.ifPresent(System.out::println);
        assertTrue(userOptional.isPresent());
    }

    @Test
    public void get2() throws Exception {
        final Optional<User> userOptional = this.userService.get("yangzg");
        userOptional.ifPresent(System.out::println);
        assertTrue(userOptional.isPresent());
    }

    @Test
    public void test() {
        System.out.println(2 << 10);
    }

    @Test
    public void locale() {
        Locale locale = Locale.CHINA;
        System.out.println(locale);

        final LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        final Instant now1 = Instant.ofEpochSecond(1);
        System.out.println(now1);

        System.out.println(now.format(DateTimeFormatter.ofPattern("yyyy mm dd HH MM ss", Locale.US)));
    }

    @Test
    public void num() {
        System.out.println(NumberFormat.getNumberInstance(Locale.CHINA).format(125234242341L));

        Arrays.stream(Locale.getAvailableLocales()).forEach(System.out::println);

        System.out.println(NumberFormat.getCurrencyInstance(Locale.TAIWAN).format(25123416234.2352));
    }

    @Test
    public void message() {
        final MessageFormat messageFormat = new MessageFormat("hello {0}, {1}", Locale.FRANCE);
        System.out.println(messageFormat.format(new Object[]{"lkdfj", 252341234L}));

        System.out.println(MessageFormat.format("hello {0}, {1}", "yzg", NumberFormat.getNumberInstance(Locale.FRANCE).format(234125123.4234)));
    }

    @Test
    public void bundle() {
        final ResourceBundle bundle = ResourceBundle.getBundle("languages/i18n", Locale.CHINA);
        System.out.println(bundle.getString("date"));
    }
}