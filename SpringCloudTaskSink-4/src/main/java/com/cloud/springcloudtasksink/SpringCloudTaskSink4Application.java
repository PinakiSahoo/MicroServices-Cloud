package com.cloud.springcloudtasksink;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.launcher.annotation.EnableTaskLauncher;

@SpringBootApplication
@EnableTaskLauncher
public class SpringCloudTaskSink4Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudTaskSink4Application.class, args);
	}

}
