package com.microservice.docker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EntityScan(basePackages = { "com.microservice.docker" })
@EnableEurekaClient
public class CurrencyConversionApplication {

    public static void main(final String[] args) {
        SpringApplication.run(CurrencyConversionApplication.class, args);
    }

}
