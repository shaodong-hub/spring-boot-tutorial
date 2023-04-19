package com.github.spring.boot.spot.controller;

import jakarta.annotation.Resource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * create in 2023/2/9 14:42
 *
 * @author shishaodong
 * @version 0.0.1
 */
@RestController
public class ThreadLocalController {

    @Resource
    private HttpServletRequest request3;

    @GetMapping("/demo01")
    public String demo01(HttpServletRequest request1) {
        HttpServletRequest request2 = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return "123";
    }

    @GetMapping("/demo02")
    public String demo02(@AuthenticationPrincipal UserDetails userDetails) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return "123";
    }
}
