package com.cloud.springcloudsecureui;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@EnableOAuth2Sso
public class ReportController extends WebSecurityConfigurerAdapter
{
	@Autowired
	private OAuth2ClientContext clientcontext;
	@Autowired
	private OAuth2RestTemplate  resttemplate;
	@RequestMapping(value ="/")
	public String home() {
		return "home";
	}
	@RequestMapping("/reports")
	public String loadReports(Model model) {
		OAuth2AccessToken t= clientcontext.getAccessToken();
		System.out.println("Token:"+t.getValue());
		ResponseEntity<ArrayList<TollUsage>> tolls=resttemplate.exchange("http://localhost:9001/services/tolldata",HttpMethod.GET,null,new ParameterizedTypeReference<ArrayList<TollUsage>>() {});
           model.addAttribute("tolls",tolls.getBody());
		return "reports";
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

	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http
		.authorizeRequests()
		.antMatchers("/","/login**")
		.permitAll()
		.anyRequest()
		.authenticated();

	}
}
