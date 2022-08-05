package com.github.spring.boot.annotation.infrastructure.profile;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * create in 2022/7/13 23:10
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Slf4j
@Profile({"redis", "test"})
@Configuration
public class ProfileBean implements InitializingBean {

    @PostConstruct
    public void init() {
        log.info("ProfileBean 生成了");
    }

    @PreDestroy
    public void des(){

    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
