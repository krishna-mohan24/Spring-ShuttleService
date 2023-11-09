package com.ood.campusshuttle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
public class CampusShuttleApplication {

	public static void main(String[] args) {
		SpringApplication.run(CampusShuttleApplication.class, args);
	}

}
