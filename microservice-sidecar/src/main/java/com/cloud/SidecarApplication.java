package com.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.sidecar.EnableSidecar;

/**
 * Created by mk on 2017/12/7.
 */
@SpringBootApplication
@EnableSidecar
public class SidecarApplication {
    public static void main(String[] args) {
        SpringApplication.run(SidecarApplication.class,args);
    }
}
