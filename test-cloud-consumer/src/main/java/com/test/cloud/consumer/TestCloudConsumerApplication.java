package com.test.cloud.consumer;

import com.test.cloud.rule.MyselfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;


/**
 * Ribbon实现客户端的负载均衡
 * 1、引入spring-cloud-starter-eureka、spring-cloud-starter-ribbon
 * 2、在RestTemplate上加入@LoadBalanced实现负载均衡
 * 3、在启动类@EnableEurekaClient激活eurekake客户端
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "TEST-CLOUD-PROVIDER",configuration = MyselfRule.class)
public class TestCloudConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestCloudConsumerApplication.class, args);
    }

}
