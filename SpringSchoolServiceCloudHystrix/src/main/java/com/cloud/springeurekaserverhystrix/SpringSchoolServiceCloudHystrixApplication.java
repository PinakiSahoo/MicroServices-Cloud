package com.cloud.springeurekaserverhystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@EnableHystrixDashboard

@EnableCircuitBreaker
@SpringBootApplication
public class SpringSchoolServiceCloudHystrixApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSchoolServiceCloudHystrixApplication.class, args);
	}

}
