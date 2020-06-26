package cloud.consumer.service.impl;

import cloud.consumer.service.ProviderClient;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @Date 2020/6/26
 * @Author tiger
 * Hystrix进行熔断的异常捕获
 */
@Component
public class ProviderClientFallBackFactory implements FallbackFactory<ProviderClient> {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProviderClientFallBackFactory.class);
    @Override
    public ProviderClient create(Throwable throwable) {
        return new ProviderClient() {
            @Override
            public String testHi(String name) {
                LOGGER.info("fallback reason is ",throwable);
                return "fail";
            }
        };
    }
}
