package com.github.spring.boot.jackson.interfaces.facade;

import com.github.spring.boot.jackson.infrastructure.common.UserInfoJsonFormat;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * create in 2022/7/31 22:25
 *
 * @author shishaodong
 * @version 0.0.1
 */
@RestController
public class JsonFormatFacade {

    @PostMapping("JsonFormat")
    public UserInfoJsonFormat jsonFormat(@RequestBody UserInfoJsonFormat format) {
        return format;
    }

}
