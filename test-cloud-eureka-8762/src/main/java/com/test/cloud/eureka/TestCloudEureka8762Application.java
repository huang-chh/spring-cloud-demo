package com.test.cloud.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class TestCloudEureka8762Application {

    public static void main(String[] args) {
        SpringApplication.run(TestCloudEureka8762Application.class, args);
    }

}
