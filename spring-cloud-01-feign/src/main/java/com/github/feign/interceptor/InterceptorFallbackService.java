package com.github.feign.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * create in 2023/7/2 22:26
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Slf4j
@Service
public class InterceptorFallbackService implements IInterceptorClient {

    @Override
    public String index() {
        log.error("------------ InterceptorFallbackService");
        return "InterceptorFallbackService";
    }

}
