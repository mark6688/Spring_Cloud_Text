package com.cloud;

import com.cloud.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Feign的fallback测试
 * 使用@FeignClient的fallback属性指定回退类
 * Created by mk on 2017/12/13.
 */
@FeignClient(name="microservice-provider-user",fallback = FeignClientFallback.class)
public interface UserFeignClient {

    @RequestMapping(value="/{id}",method= RequestMethod.GET)
    public User Movie_feign_stream(@PathVariable("id") Long id);
}
