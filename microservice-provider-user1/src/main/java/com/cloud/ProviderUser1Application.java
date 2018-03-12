package com.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * user启动类
 * @EnableDiscoveryClient 注解证明这是一个客户端(该注解可以支持eureka、zookeeper、consul)
 * @EnableEurekaClient 该注解只适用于Eureka
 * Created by mk on 2017/12/5.
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ProviderUser1Application {
    public static void main(String[] args) {
        SpringApplication.run(ProviderUser1Application.class,args);
    }
}
