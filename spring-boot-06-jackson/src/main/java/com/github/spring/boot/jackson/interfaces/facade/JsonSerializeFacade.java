package com.github.spring.boot.jackson.interfaces.facade;

import com.github.spring.boot.jackson.infrastructure.common.UserInfoJsonSerialize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * create in 2022/8/1 09:53
 *
 * @author shishaodong
 * @version 0.0.1
 */
@RestController
public class JsonSerializeFacade {

    @PostMapping("JsonSerialize")
    public UserInfoJsonSerialize jsonSerialize(@RequestBody UserInfoJsonSerialize jsonSerialize) {
        return jsonSerialize;
    }

}
