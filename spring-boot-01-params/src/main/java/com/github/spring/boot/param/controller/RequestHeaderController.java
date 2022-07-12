package com.github.spring.boot.param.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

/**
 * create in 2022/7/11 20:56
 *
 * @author shishaodong
 * @version 0.0.1
 */
@RestController
public class RequestHeaderController {

    @GetMapping("header")
    public String cookie(@RequestHeader(name = "Token") String token) {
        return token;
    }

}
