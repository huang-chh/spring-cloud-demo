package com.test.cloud.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/consumer")
public class HiController {
    private static final String REST_URL_PRIFIX = "http://TEST-CLOUD-PROVIDER";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/hello")
    public String sayHello(){
        return restTemplate.postForObject(REST_URL_PRIFIX+"/hello","annie",String.class);
    }

}
