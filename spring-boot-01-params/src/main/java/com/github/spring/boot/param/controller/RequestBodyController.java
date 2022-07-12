package com.github.spring.boot.param.controller;

import com.github.spring.boot.param.pojo.UserInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * create in 2022/7/11 20:39
 *
 * @author shishaodong
 * @version 0.0.1
 */
@RestController
public class RequestBodyController {

    /**
     * 从 body 里面取出数据
     *
     * @param userInfo UserInfo
     * @return UserInfo
     */
    @PostMapping("body")
    public UserInfo body(@RequestBody UserInfo userInfo) {
        return userInfo;
    }

}

