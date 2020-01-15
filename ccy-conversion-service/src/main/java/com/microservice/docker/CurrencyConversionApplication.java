package com.microservice.docker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = { "com.microservice.docker" })
// @EnableEurekaClient
public class CurrencyConversionApplication {

    public static void main(final String[] args) {
        SpringApplication.run(CurrencyConversionApplication.class, args);
    }

}
