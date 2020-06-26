package cloud.consumer.controller;

import cloud.consumer.service.ProviderClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/consumer")
public class HiController {

    @Autowired
    private ProviderClient providerClient;

    @RequestMapping("/feign/{name}")
    public String sayHello(@PathVariable("name") String name){
        return providerClient.testHi(name) ;
    }

}
