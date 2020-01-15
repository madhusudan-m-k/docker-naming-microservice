package com.namingserver.docker.microservicenamingserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CurrencyServiceNamingServer {

    public static void main(String[] args) {
        SpringApplication.run(CurrencyServiceNamingServer.class, args);
    }

}
