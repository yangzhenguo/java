package com.yangzg.spring.chapter04;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Created by Sam on 2019/6/19.
 */
@Service
public class TaskService {
    @Scheduled(cron = "*/1 * * * * *")
    public void reportCurrentTime() {
        System.out.println("每秒钟执行");
    }
}
