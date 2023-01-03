package com.github.spring.boot.jackson.interfaces.facade;

import com.github.spring.boot.jackson.infrastructure.common.UserInfoJsonPropertyOrder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * create in 2022/8/1 10:43
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Slf4j
@RestController
public class JsonPropertyOrderFacade {

    @PostMapping("JsonPropertyOrder")
    public UserInfoJsonPropertyOrder jsonPropertyOrder(@RequestBody UserInfoJsonPropertyOrder jsonPropertyOrder) {
        //
        return jsonPropertyOrder;
    }

}
