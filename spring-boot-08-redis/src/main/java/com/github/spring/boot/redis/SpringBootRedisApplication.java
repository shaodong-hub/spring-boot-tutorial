package com.github.spring.boot.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * create in 2022/8/6 16:08
 *
 * @author shishaodong
 * @version 0.0.1
 */
@EnableScheduling
@SpringBootApplication
public class SpringBootRedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRedisApplication.class, args);
    }

}
