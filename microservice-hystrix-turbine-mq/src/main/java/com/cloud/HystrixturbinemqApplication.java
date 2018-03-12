package com.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.stream.EnableTurbineStream;

/**
 * Created by mk on 2017/12/6.
 */
@SpringBootApplication
@EnableTurbineStream
public class HystrixturbinemqApplication {

    public static void main(String[] args) {
        SpringApplication.run(HystrixturbinemqApplication.class,args);
    }
}
