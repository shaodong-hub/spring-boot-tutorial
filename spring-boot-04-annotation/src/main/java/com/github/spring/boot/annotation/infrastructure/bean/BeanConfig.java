package com.github.spring.boot.annotation.infrastructure.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * create in 2022/7/13 22:51
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Slf4j
@Configuration
public class BeanConfig {

    @Bean
    @Primary
    public UserInfo userInfo1() {
        return new UserInfo("test name 1", location().getLoc());
    }

    @Bean
    public UserInfo userInfo2() {
        return new UserInfo("test name 2", location().getLoc());
    }

    @Bean
    public Location location() {
        log.info("Location");
        return new Location("cmcc");
    }

}
