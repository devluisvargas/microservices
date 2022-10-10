package com.devluis.microservices.motorcycles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MotorcyclesApplication {

    public static void main(String[] args) {
        SpringApplication.run(MotorcyclesApplication.class, args);
    }

}
