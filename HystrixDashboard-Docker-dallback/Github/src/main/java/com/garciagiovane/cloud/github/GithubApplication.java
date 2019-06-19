package com.garciagiovane.cloud.github;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.garciagiovane.cloud")
public class GithubApplication {

    public static void main(String[] args) {
    	SpringApplication.run(GithubApplication.class, args);
    }
}