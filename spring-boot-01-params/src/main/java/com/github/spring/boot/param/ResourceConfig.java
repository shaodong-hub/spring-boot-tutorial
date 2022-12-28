package com.github.spring.boot.param;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * create in 2022/12/20 16:45
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Slf4j
@Component
public class ResourceConfig {
    @Data
    @Component("resConfig")
    @ConfigurationProperties("com.matrix")
    @SuppressWarnings("unused")
    static class ResourcePathConfig {
        private String resourcePath;

        public String getResourcePath() {
            return StringUtils.hasText(this.resourcePath) ? this.resourcePath : "classpath:data/test1.json";
        }
    }

    @Value("#{resConfig.getResourcePath()}")
    private Resource resource;

    @PostConstruct
    public void init() throws IOException {
        String string = IOUtils.toString(resource.getInputStream(), StandardCharsets.UTF_8);
        log.info("{}", string);
    }
}
