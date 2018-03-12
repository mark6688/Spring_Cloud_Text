package com.cloud;

import com.cloud.entity.User;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * Created by mk on 2017/12/13.
 */
@FeignClient(name="microservice-provider-user",configuration = FeignConfiguration.class)
public interface UserFeignClient {

    /**
     * 使用feign自带的注解@RequestLine
     *
     * @param id 用户id
     * @return 用户信息
     */
    @RequestLine("GET /{id}")
    User findById(@Param("id") Long id);
}
