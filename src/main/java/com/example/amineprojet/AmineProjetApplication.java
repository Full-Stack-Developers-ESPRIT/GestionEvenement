package com.example.amineprojet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AmineProjetApplication {

    public static void main(String[] args) {
        SpringApplication.run(AmineProjetApplication.class, args);
    }

}
