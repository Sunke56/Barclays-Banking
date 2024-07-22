package com.barclays.offers;

import com.barclays.offers.enrollment.svcclient.EnrollmentServiceClientImpl;
import com.barclays.offers.model.EnrollmentRequest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class CardOffersDetailsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CardOffersDetailsServiceApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(){

		return new RestTemplate();

	}

}
