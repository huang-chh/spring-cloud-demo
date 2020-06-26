package com.test.cloud.testcloudprovider.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/hello")
    public String sayHello(){
        List<String> list = discoveryClient.getServices();
        System.out.println(list);
        List<ServiceInstance> list2 = discoveryClient.getInstances("test-cloud-provider");
        for(ServiceInstance s:list2){
            System.out.println(s.getHost()+"\t"+s.getPort()+"\t"+s.getServiceId()+"\t");
        }
        return "success";
    }

    @RequestMapping("/hi/{name}")
    @HystrixCommand(fallbackMethod = "sayHiFallBack")
    //如果配置了全局的超时时间，这里的超时时间就不生效了
    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "8000")
    public String sayHi(@PathVariable("name") String name) throws InterruptedException {
        Thread.sleep(20000);
        List<String> list = discoveryClient.getServices();
        System.out.println("hi, "+name);
        return "success";
    }
    //这里要注意：方法中的参数，和返回值要与原方法中相同，如果需要获取异常信息，再加入参数Throwable
    public String sayHiFallBack(String name,Throwable throwable){
        LOGGER.info("fallback reason is ",throwable);
        return "server is error";
    }

}
