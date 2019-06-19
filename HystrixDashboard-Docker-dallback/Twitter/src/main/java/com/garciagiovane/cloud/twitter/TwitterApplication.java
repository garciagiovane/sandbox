package com.garciagiovane.cloud.twitter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.garciagiovane.cloud")
public class TwitterApplication {

    public static void main(String[] args) {
    	SpringApplication.run(TwitterApplication.class, args);
    }
}