package com.github.spring.boot.annotation.infrastructure.profile;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.annotation.PostConstruct;

/**
 * create in 2022/7/13 23:10
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Slf4j
@Profile("redis")
@Configuration
public class ProfileBean {

    @PostConstruct
    public void init(){
        log.info("ProfileBean 生成了");
    }

}
