package com.cloud;

import com.cloud.entity.User;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * UserFeignClient的fallbackFactory类，该类需要实现fallbackFactory接口，并覆盖creat方法
 * The fallback factory must produce instances of fallback classes that
 * implement the interface annotated by{@link }
 * Created by mk on 2017/12/19.
 */
@Component
public class FeignClientFallbackFactory implements FallbackFactory<UserFeignClient> {
    private static final Logger LOGGER = LoggerFactory.getLogger(FeignClientFallbackFactory.class);

    @Override
    public UserFeignClient create(Throwable cause) {
        return new UserFeignClient() {
            @Override
            public User findById(Long id) {
                //日志最好放在哥哥fallback方法中，而不要直接放在create方法中
                //否则在引用启动时，就会打印该日志
                //
                FeignClientFallbackFactory.LOGGER.info("fallback;reason was:",cause);
                User user = new User();
                user.setId(-1L);
                user.setUsername("默认用户");
                return user;
            }
        };
    }
}
