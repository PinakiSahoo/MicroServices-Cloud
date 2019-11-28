package com.cloud.springcloudsecureservice;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableResourceServer
public class SpringCloudSecureService6Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudSecureService6Application.class, args);
	}
	
     @Autowired   
	private ResourceServerProperties sso;
     @Bean
     public ResourceServerTokenServices myUserInfoTokenServices() {
    	 return new CustomUserInfoTokenServices(sso.getUserInfoUri(),sso.getClientId());
     }
	
	@RequestMapping("/tolldata")
	@PreAuthorize("#oauth2.hasScope('toll_read')and hasAuthority('ROLE_OPERATOR')")
	public ArrayList<TollUsage> getTolldata(){
		TollUsage instance1=new TollUsage("wa323","432","OD02ab1235","4.00pm");
		TollUsage instance2=new TollUsage("wa324","433","OD02ab1256","5.00pm");
		TollUsage instance3=new TollUsage("wa325","434","OD02ab1232","8.00pm");
		ArrayList<TollUsage> tolls=new ArrayList<TollUsage>();
		tolls.add(instance1);
		tolls.add(instance2);
		tolls.add(instance3);
		return tolls;
	}
	
	public class TollUsage{
		public String id;
		public String StationId;
		public String licensePlate;
		public String timeStamp;

		public TollUsage() {}

		public TollUsage(String id, String stationId, String licensePlate, String timeStamp) {
			super();
			this.id = id;
			this.StationId = stationId;
			this.licensePlate = licensePlate;
			this.timeStamp = timeStamp;
		}


	}

}
