package com.github.feign.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;

/**
 * create in 2023/7/2 23:43
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Slf4j
public class FeignBasicAuthRequestInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate requestTemplate) {
        log.info("---------------------- {}", FeignBasicAuthRequestInterceptor.class.getSimpleName());
        requestTemplate.header("DemoHeader", "Value");
    }

}
