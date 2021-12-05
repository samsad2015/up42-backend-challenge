package com.up42.backendchallenge;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.up42.backendchallenge.feature.model.Feature;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class BackendChallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendChallengeApplication.class, args);
	}


//	@Bean
//	CommandLineRunner runner(UserService userService) {
//		return args -> {
//			// read json and write to db
//			ObjectMapper mapper = new ObjectMapper();
//			TypeReference<> typeReference = new TypeReference<List<Feature>>(){};
//
//			InputStream inputStream = TypeReference.class.getResourceAsStream("source-data.json");
//			System.out.println(mapper.readValues(inputStream, typeReference));
//		};
//	}
}
