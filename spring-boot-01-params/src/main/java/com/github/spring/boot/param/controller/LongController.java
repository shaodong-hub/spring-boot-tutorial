package com.github.spring.boot.param.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * create in 2022/8/4 17:42
 *
 * @author shishaodong
 * @version 0.0.1
 */

@RestController
public class LongController {


    @GetMapping("long")
    public Long getLong() {
        boolean t = Long.MAX_VALUE == 9223372036854775807L;
        System.out.println(t);
        return Long.MAX_VALUE;
    }
}
