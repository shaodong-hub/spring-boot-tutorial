package com.github.spring.boot.annotation.infrastructure.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * create in 2022/7/13 22:41
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "com.github.property")
public class PropertiesConfig {

    /**
     * 密码
     */
    private String password;


    /**
     * 账号
     */
    private String username;
}
