package com.cloud;

import com.cloud.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by mk on 2017/12/13.
 */
@FeignClient(name="microservice-provider-user")
public interface UserFeignClient {

    @RequestMapping(value="/{id}",method= RequestMethod.GET)
    public User findById(@PathVariable("id") Long id);
}
