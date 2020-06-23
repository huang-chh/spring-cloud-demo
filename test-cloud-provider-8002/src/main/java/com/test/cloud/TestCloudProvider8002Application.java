package com.test.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class TestCloudProvider8002Application {

    public static void main(String[] args) {
        SpringApplication.run(TestCloudProvider8002Application.class, args);
    }

}
