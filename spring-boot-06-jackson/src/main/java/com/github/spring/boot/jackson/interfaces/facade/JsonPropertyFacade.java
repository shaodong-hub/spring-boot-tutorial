package com.github.spring.boot.jackson.interfaces.facade;

import com.github.spring.boot.jackson.infrastructure.common.UserInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * create in 2022/7/17 23:53
 *
 * @author shishaodong
 * @version 0.0.1
 */
@RestController
public class JsonPropertyFacade {

    @GetMapping("json")
    public UserInfo userInfo() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("test_username");
        userInfo.setNote("test_note");
        userInfo.setPass("123456");
        userInfo.setDateTime(LocalDateTime.now());
        return new UserInfo();
    }

    @PostMapping("json")
    public UserInfo userInfo(@RequestBody UserInfo userInfo) {
        return userInfo;
    }


}
