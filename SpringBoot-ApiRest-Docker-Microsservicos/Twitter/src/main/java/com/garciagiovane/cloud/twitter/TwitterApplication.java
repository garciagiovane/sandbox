package com.garciagiovane.cloud.twitter;

import com.garciagiovane.cloud.cliente.ClienteTwitter;
import org.springframework.boot.SpringApplication;

public class TwitterApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClienteTwitter.class, args);
    }
}