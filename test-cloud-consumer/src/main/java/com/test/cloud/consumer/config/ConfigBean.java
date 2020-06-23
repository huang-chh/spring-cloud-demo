package com.test.cloud.consumer.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {

    @Bean
    @LoadBalanced   //Ribbon实现客户端的负载均衡
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    /**
     * Ribbon负载均衡算法的选择
     *
     * @return
     */
    @Bean
    public IRule myRule() {
        return new RoundRobinRule();
//        return new RandomRule(); //随机算法
        //如果服务都正常，效果等于轮询
        //如果发现有失败的，在重试几次后，都失败则自动剔除问题服务
//        return new RetryRule();
    }

}
