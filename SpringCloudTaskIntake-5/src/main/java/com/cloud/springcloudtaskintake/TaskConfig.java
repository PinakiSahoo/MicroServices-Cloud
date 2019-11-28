package com.cloud.springcloudtaskintake;

import org.springframework.context.annotation.Configuration;

@Configuration
public class TaskConfig {

	
	public TaskProcessor taskprocessor() {
		return new TaskProcessor();
	}
}
