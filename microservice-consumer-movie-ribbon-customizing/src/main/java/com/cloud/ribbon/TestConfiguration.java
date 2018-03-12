package com.cloud.ribbon;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Configuration;

/**
 * Created by mk on 2017/12/12.
 */
@Configuration
@RibbonClient(name="microservice-provider-user",configuration=RibbonConfiguration.class)
public class TestConfiguration {
}
