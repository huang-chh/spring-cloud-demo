package cloud.consumer.service;

import cloud.consumer.service.impl.HystrixProviderClient;
import cloud.consumer.service.impl.ProviderClientFallBackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Date 2020/6/25
 * @Author tiger
 */
//@FeignClient(value = "test-cloud-provider",fallback = HystrixProviderClient.class)
@FeignClient(value = "test-cloud-provider",fallbackFactory = ProviderClientFallBackFactory.class)
public interface ProviderClient {

    @RequestMapping("/hi/{name}")
    public String testHi(@PathVariable("name") String name);
}
