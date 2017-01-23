package com.example;

import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {

	private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@GetMapping
	String hello() {
		log.info("Received a request!");
		return "Hello from instance id [" + System.getenv("CF_INSTANCE_INDEX") + "]";
	}

	@GetMapping("/kill")
	void kill() {
		log.info("Will kill the application :(");
		System.exit(1);
	}
}
