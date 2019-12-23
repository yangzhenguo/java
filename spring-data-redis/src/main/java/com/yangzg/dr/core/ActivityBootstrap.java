package com.yangzg.dr.core;

import com.yangzg.dr.service.ActivityService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.ListOperations;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by Sam on 2019/12/18.
 */
@Configuration
public class ActivityBootstrap implements InitializingBean {
    private static final String KEY = "names";

    @Value("#{ redisTemplate.opsForList() }")
    private ListOperations<String, String> listOperations;

    @Autowired
    private ExecutorService executorService;

    @Autowired
    private List<ActivityService> activityServices;

    @Override
    public void afterPropertiesSet() throws Exception {
        this.executorService.submit(() -> {
            while (true) {
                final String name = this.listOperations.rightPop(KEY, 0, TimeUnit.SECONDS);
                this.activityServices.forEach(activityService -> {
                    if (activityService.using()) {
                        this.executorService.submit(() -> activityService.execute(KEY, name));
                    }
                });
            }
        });
    }
}
