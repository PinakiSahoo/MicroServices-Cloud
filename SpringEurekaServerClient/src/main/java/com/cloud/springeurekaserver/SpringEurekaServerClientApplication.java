package com.cloud.springeurekaserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.discovery.EurekaClient;
@RestController
@SpringBootApplication
public class SpringEurekaServerClientApplication implements GreetingController {
	@Autowired
	@Lazy
	private EurekaClient eurekaclient;
	@Value("${spring.application.name}")
	private String appName;

	public static void main(String[] args) {
		SpringApplication.run(SpringEurekaServerClientApplication.class, args);
	}

	@Override
	public String greeting() {
		  return String.format(
		          "Hello from '%s'!", eurekaclient.getApplication(appName).getName());
	}

}
