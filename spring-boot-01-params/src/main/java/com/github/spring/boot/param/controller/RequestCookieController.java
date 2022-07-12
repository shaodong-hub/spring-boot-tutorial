package com.github.spring.boot.param.controller;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * create in 2022/7/11 20:58
 *
 * @author shishaodong
 * @version 0.0.1
 */
@RestController
public class RequestCookieController {

    @GetMapping("cookie")
    public String cookie(@CookieValue(name = "SESSION") String session) {
        return session;
    }

}
