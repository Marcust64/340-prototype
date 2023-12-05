package com.pickandgo.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.pickandgo.demo.packages, com.pickandgo.demo.user, com.pickandgo.demo.Security, com.pickandgo.demo.PackagesTour, com.pickandgo.demo.Applications")
public class Application {

	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);

	}

}
