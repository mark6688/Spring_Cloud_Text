package com.cloud.ribbon;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by mk on 2017/12/12.
 */
@Configuration
public class RibbonConfiguration {
    @Bean
    public IRule ribbonRule(){
        //负载均衡规则，改为随机
        return new RandomRule();
    }
}
