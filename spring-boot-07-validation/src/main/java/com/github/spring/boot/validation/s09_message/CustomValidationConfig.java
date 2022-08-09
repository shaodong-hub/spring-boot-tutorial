package com.github.spring.boot.validation.s09_message;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

/**
 * create in 2022/8/6 22:31
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Configuration
public class CustomValidationConfig {

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource source = new ResourceBundleMessageSource();
        //读取配置文件的编码格式
        source.setDefaultEncoding("utf-8");
        //缓存时间，-1表示不过期
        source.setCacheMillis(-1);
        //配置文件前缀名，设置为Messages,那你的配置文件必须以Messages.properties/Message_en.properties...
        source.setBasename("ValidationMessages");
        return source;
    }
}
