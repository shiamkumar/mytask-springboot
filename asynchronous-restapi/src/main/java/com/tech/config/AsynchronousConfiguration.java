package com.tech.config;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.stereotype.Component;

@Component
public class AsynchronousConfiguration implements AsyncConfigurer {
	
	@Bean(name = "asyncExecutor")
	public Executor getAsyncExecutor() {
		return Executors.newCachedThreadPool();
	}

//	@Bean(name = "asyncExecutor")
//    public Executor asyncExecutor() {
//        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
//        executor.setCorePoolSize(20);
//        executor.setMaxPoolSize(1000);
//        executor.setWaitForTasksToCompleteOnShutdown(true);
//        executor.setThreadNamePrefix("Async-");
//        executor.initialize();
//        return executor;
//    }
	
}
