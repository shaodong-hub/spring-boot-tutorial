package com.github.spring.boot.redis.infrastructure.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Role;
import org.springframework.core.io.Resource;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.scripting.support.ResourceScriptSource;

/**
 * create in 2023/1/31 14:51
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Configuration
public class FiniteTimeSetRedisScriptConfig {

    @Value("classpath:script/finite_time_set.lua")
    private Resource resource;

    @Bean
    @ConditionalOnMissingBean
    @Role(BeanDefinition.ROLE_INFRASTRUCTURE)
    public RedisScript<Long> finiteTimeSet() {
        DefaultRedisScript<Long> script = new DefaultRedisScript<>();
        script.setScriptSource(new ResourceScriptSource(resource));
        script.setResultType(Long.class);
        return script;
    }

}
