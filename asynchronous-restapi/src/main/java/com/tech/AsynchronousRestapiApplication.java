package com.tech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class AsynchronousRestapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AsynchronousRestapiApplication.class, args);
	}

}
