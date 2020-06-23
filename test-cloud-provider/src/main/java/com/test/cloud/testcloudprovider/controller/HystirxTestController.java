package com.test.cloud.testcloudprovider.controller;

import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HystirxTestController {


    @RequestMapping("/test01")
    public String sayHello(){

        return "hello world";
    }
}
