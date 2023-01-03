package com.github.spring.boot.jpa.s04_projection;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * create in 2023/1/4 01:20
 *
 * @author shishaodong
 * @version 0.0.1
 */
@RestController
public class User04Facade {


    @PostMapping("user04")
    public IWebDataBindingProjection projection(@RequestBody IWebDataBindingProjection projection) {
        return projection;
    }


}
