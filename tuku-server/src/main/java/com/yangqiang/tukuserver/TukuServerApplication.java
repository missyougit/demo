package com.yangqiang.tukuserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

@SpringBootApplication
@MapperScan("com.yangqiang.tukuserver.mapper")
public class TukuServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TukuServerApplication.class, args);
    }


    @Bean
    public ThreadPoolTaskScheduler threadPoolTaskScheduler(){
        ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
        // 定时任务执行线程池核心线程数
        threadPoolTaskScheduler.setPoolSize(4);
        threadPoolTaskScheduler.setRemoveOnCancelPolicy(true);
        threadPoolTaskScheduler.setThreadNamePrefix("TaskSchedulerThreadPool-");
        return threadPoolTaskScheduler;
    }


}
