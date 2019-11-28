package com.cloud.springcloudtask;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableTask
public class SpringCloudTask3Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudTask3Application.class, args);
	}
  @Bean
  public TollProcessingTask tollProcessingTash() {
	  return new TollProcessingTask();
  }
  
  public class TollProcessingTask implements CommandLineRunner{

	@Override
	public void run(String... strings) throws Exception {
		// parameters stationid,license plate,timestamp
		
		if(null != strings) {
			System.out.println("parameter length is "+strings.length);
			
		   String stationid=strings[1];
		   String licenseplate=strings[2];
		   String timestamp=strings[3];
		 
		   System.out.println("Station ID is" +stationid+ ",plate is" +licenseplate+ ",time is" +timestamp);
		   		
			
		}
		
	}
	  
  }
  
}
