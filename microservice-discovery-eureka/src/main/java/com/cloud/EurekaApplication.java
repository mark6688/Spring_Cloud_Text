package com.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by mk on 2017/12/7.
 */
@SpringBootApplication
@EnableEurekaServer
//@EnableScheduling
public class EurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication.class,args);
       /*
        String str = "aaa我我我123";
        System.out.println(str.length());

        String b=str.substring(0,1);
        str =str.substring(1);
        System.out.println("========"+b.length());
      /*  System.out.println("11111===="+str.length());*//*
        URLAvailability urlAvailability = new URLAvailability();
        urlAvailability.isConnect("http://osstest.huayun.cdvcloud.com/onair/QMTNRK_YUNSHI/5a3b83397f4b664174988b42/a4f9c8e21dd67d626491a8d4b04a5bb6.jpg");
        */


    }
}
