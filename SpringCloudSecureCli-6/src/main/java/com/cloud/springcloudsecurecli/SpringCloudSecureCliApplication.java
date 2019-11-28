package com.cloud.springcloudsecurecli;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.security.oauth2.common.AuthenticationScheme;

@SpringBootApplication
public class SpringCloudSecureCliApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudSecureCliApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("starting ajob");
		ResourceOwnerPasswordResourceDetails resourceDetails=new ResourceOwnerPasswordResourceDetails();
		 resourceDetails.setClientAuthenticationScheme(AuthenticationScheme.header);
		 resourceDetails.setAccessTokenUri("http://localhost:9000/services/oauth/token");
		 resourceDetails.setScope(Arrays.asList("toll_read"));
		 resourceDetails.setClientId("github");
		 resourceDetails.setClientSecret("githubsecret");
		 resourceDetails.setUsername("pinaki");
		 resourceDetails.setPassword("deba");
		 
		 OAuth2RestTemplate template=new OAuth2RestTemplate(resourceDetails);
		 
		 String token=template.getAccessToken().toString();
		 System.out.println("Token:" +token);
		 
		 String s=template.getForObject("http://localhost:9001/services/tolldata",String.class);
		 System.out.println("Result: "+s);
		 
		 
		 
		 
		 
	}

}
