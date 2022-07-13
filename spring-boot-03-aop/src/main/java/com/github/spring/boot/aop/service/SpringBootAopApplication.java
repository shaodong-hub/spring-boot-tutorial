package com.github.spring.boot.aop.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * create in 2022/7/13 20:58
 *
 * @author shishaodong
 * @version 0.0.1
 */
@EnableAspectJAutoProxy
@SpringBootApplication
public class SpringBootAopApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootAopApplication.class, args);
    }

}
