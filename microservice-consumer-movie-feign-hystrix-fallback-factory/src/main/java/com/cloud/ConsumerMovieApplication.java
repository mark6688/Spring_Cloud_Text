package com.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * movie启动类
 * @EnableDiscoveryClient 注解证明这是一个客户端(该注解可以支持eureka、zookeeper、consul)
 * @EnableEurekaClient 该注解只适用于Eureka
 * Created by mk on 2017/12/6.
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
public class ConsumerMovieApplication {
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(ConsumerMovieApplication.class,args);
    }
}
