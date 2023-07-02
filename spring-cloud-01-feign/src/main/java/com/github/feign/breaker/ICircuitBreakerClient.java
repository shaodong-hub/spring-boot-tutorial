package com.github.feign.breaker;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * create in 2023/7/2 22:24
 *
 * @author shishaodong
 * @version 0.0.1
 */
@FeignClient(name = "ICircuitBreakerClient", url = "http://www.zorbus.cn/api", fallback = CircuitBreakerFallbackService.class)
public interface ICircuitBreakerClient {

    @GetMapping("/index")
    String index();
}
