package com.cloud.controller;

import com.cloud.UserFeignClient;
import com.cloud.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mk on 2017/12/6.
 */
@RestController
public class MoveController {

    @Autowired
    private UserFeignClient userFeignClient;

    @GetMapping("/user/{id}")
    public User findById(@PathVariable Long id){
        return this.userFeignClient.findById(id);
    }
}
