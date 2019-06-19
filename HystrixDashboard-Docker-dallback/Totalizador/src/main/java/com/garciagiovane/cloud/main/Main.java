package com.garciagiovane.cloud.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.garciagiovane.cloud")
public class Main {
	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
    }
}
