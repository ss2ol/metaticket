package com.metaticket.metaticket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class MetaticketApplication {

	public static void main(String[] args) {
		SpringApplication.run(MetaticketApplication.class, args);
	}

	@GetMapping("/")
	public String FirstTest(){
		return "성공했나요?";
	}

}
