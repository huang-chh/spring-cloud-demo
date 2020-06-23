package com.test.cloud.testcloudprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class TestCloudProvider8003Application {

    public static void main(String[] args) {
        SpringApplication.run(TestCloudProvider8003Application.class, args);
    }

}
