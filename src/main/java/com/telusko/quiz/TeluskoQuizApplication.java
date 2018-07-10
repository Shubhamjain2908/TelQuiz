package com.telusko.quiz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.telusko.quiz.controller", "com.telusko.quiz.service"})
@EntityScan("com.telusko.quiz.entity")
@EnableJpaRepositories("com.telusko.quiz.repository")
public class TeluskoQuizApplication {

	public static void main(String[] args) {
		SpringApplication.run(TeluskoQuizApplication.class, args);
	}
}
