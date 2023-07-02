package com.github.feign.facade;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * create in 2023/7/2 23:53
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Slf4j
@RestController
public class FeignFacade {

    @GetMapping("/index")
    public String index(@RequestHeader("DemoHeader") String header) {
        String string = new Date().toString();
        log.info("---------------- {} - {}", header, string);
        return string;
    }

}
