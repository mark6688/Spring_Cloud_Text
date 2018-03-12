package com.cloud;

import com.cloud.entity.User;
import org.springframework.stereotype.Component;

/**
 * 回退类FeignClientFallback需事先FeignClient接口
 * FeignClientFallback也可以是public class，没有区别
 * Created by mk on 2017/12/19.
 */
@Component
public class FeignClientFallback implements UserFeignClient {
    @Override
    public User Movie_feign_stream(Long id) {
        User user = new User();
        user.setId(-1L);
        user.setUsername("默认用户");
        return user;
    }
}
