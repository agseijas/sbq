package com.mk.hx.sbqmodule;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootTest(webEnvironment = RANDOM_PORT)
public class _3_TheWebEnvironmentCakeIsALie {

	@Autowired
	TestRestTemplate restClient;

	//ERROR IS: `Caused by: org.springframework.context.ApplicationContextException: Unable to start ServletWebServerApplicationContext due to missing ServletWebServerFactory bean.`

	@Test
	public void contextLoads() {
		ResponseEntity<String> response = restClient.getForEntity("/my-mapping", String.class);

		assertThat(response.getBody(), is("myContent"));
	}

	@Configuration
	//BECAUSE IT'S TRYING TO FIND (BUT IT CAN'T) AN @EnableAutoConfiguration  --- THAT IS INSIDE @SpringBootApplication WHICH USUALLY IS SCANNED IN TYPICAL @SpringBootTest APPLICATIONS.
	//@EnableAutoConfiguration
	public static class Conf{
		@RestController
		public static class MyTestRestController {

			@GetMapping("/my-mapping")
			public String myMapping(){
				return "myContent";
			}
		}
	}


}
