package com.donggun.eplalarmi.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync
public class AsyncConfiguration {
    @Bean(name = "asyncExecutor")
    public Executor asyncExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(5); // 기본 스레드 사이즈
        taskExecutor.setMaxPoolSize(10); // 최대 스레드 사이즈
        taskExecutor.setQueueCapacity(1000); // 최대 스레드 사이즈가 동작하는 경우 대기하는 queue 사이즈
        taskExecutor.setThreadNamePrefix("asyncExecutor-"); // 스레드 이름
        taskExecutor.initialize();
        return taskExecutor;
    }
}
