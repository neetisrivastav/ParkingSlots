package com.students.event;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })

public class StudentsEventApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentsEventApplication.class, args);
	}

}
