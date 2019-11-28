package com.cloud.springeurekaserverhystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
@EnableHystrixDashboard
@SpringBootApplication
public class SpringHystrixDashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringHystrixDashboardApplication.class, args);
	}

}
