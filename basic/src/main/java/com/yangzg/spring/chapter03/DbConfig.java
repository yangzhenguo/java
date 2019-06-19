package com.yangzg.spring.chapter03;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

/**
 * Created by Sam on 2019/6/18.
 */
@Data
@Component
public class DbConfig {
    @Value("${db.username}")
    private String username;

    @Value("${db.password}")
    private String password;

    @Value("https://api.github.com/users/solomonxie/")
    private Resource url;

    @Value("${spring.profiles.active}")
    private String profile;

    @Value("${os.name}")
    private String name;
}
