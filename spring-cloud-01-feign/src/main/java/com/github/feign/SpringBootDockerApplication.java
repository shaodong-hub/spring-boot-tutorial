package com.github.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * create in 2022/8/6 16:08
 *
 * @author shishaodong
 * @version 0.0.1
 */
@EnableFeignClients
@SpringBootApplication
public class SpringBootDockerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDockerApplication.class, args);
    }

}
