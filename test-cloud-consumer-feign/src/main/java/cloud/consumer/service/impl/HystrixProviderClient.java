package cloud.consumer.service.impl;

import cloud.consumer.service.ProviderClient;
import org.springframework.stereotype.Component;

/**
 * @Date 2020/6/25
 * @Author tiger
 */
@Component
public class HystrixProviderClient implements ProviderClient {
    @Override
    public String testHi(String name) {
        return "hahaha";
    }
}
