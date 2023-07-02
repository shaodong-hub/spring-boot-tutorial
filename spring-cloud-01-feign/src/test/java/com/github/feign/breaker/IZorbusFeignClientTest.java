package com.github.feign.breaker;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * create in 2023/7/2 22:26
 *
 * @author shishaodong
 * @version 0.0.1
 */
@SpringBootTest
class IZorbusFeignClientTest {

    @Resource
    ICircuitBreakerClient zorbusFeignClient;

    @Test
    void index() {
        String index = zorbusFeignClient.index();
        System.out.println(index);
    }
}