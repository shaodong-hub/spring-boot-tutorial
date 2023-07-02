package com.github.feign.interceptor;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * create in 2023/7/2 23:50
 *
 * @author shishaodong
 * @version 0.0.1
 */
@FeignClient(name = "IInterceptorClient", url = "http://www.baidu.com", configuration = FeignBasicAuthRequestInterceptor.class, fallback = InterceptorFallbackService.class)
public interface IInterceptorClient {

    @GetMapping("index")
    String index();

}



