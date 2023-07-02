package com.github.feign.breaker;

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
public class CircuitBreakerFallbackService implements ICircuitBreakerClient {

    @Override
    public String index() {
        log.error("CircuitBreakerFallbackService");
        return "CircuitBreakerFallbackService";
    }

}
