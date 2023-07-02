package com.github.feign.interceptor;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * create in 2023/7/2 23:58
 *
 * @author shishaodong
 * @version 0.0.1
 */
@SpringBootTest
@DirtiesContext
@AutoConfigureWireMock(stubs = "classpath:/stubs")
class IInterceptorClientTest {

    @Resource
    IInterceptorClient interceptorClient;

    @Test
    void index() {
        String index = interceptorClient.index();
        System.out.println(index);
    }
}