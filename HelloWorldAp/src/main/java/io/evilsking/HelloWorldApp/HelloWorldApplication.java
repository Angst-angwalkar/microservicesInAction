package io.evilsking.HelloWorldApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

import Models.HelloRequestModel;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@SpringBootApplication
@RestController
@RequestMapping(value="hello")
public class HelloWorldApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloWorldApplication.class, args);
	}
	
	@GetMapping(value="/{firstName}")
	public String helloGet(
			@PathVariable("firstName") String firstName, 
			@RequestParam("lastName") String lastName
			) 
	{
		return String.format("{\"message\": \"Hello %s %s\"}", firstName, lastName);
	}
	
	@PostMapping()
	public HelloRequestModel helloPost(@RequestBody HelloRequestModel helloRequestModel) {
//		return String.format("{\"message\": \"Hello %s %s\"}", helloRequestModel.getFirstName(), helloRequestModel.getLastName());
		return helloRequestModel;
	}

}
