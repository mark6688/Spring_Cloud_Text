package com.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * Created by mk on 2017/12/6.
 */
@SpringBootApplication
@EnableTurbine
public class HystrixturbineApplication {

    public static void main(String[] args) {
        SpringApplication.run(HystrixturbineApplication.class,args);
    }
}
