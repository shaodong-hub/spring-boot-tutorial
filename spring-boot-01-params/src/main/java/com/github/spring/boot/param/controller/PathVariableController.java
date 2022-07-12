package com.github.spring.boot.param.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 * create in 2022/7/11 20:53
 *
 * @author shishaodong
 * @version 0.0.1
 */
@RestController
public class PathVariableController {

    @GetMapping("path/simple/{message}")
    public String pathSimple(@PathVariable String message) {
        return message;
    }

    @GetMapping("path/list/{ids}")
    public Set<Long> pathList(@PathVariable Set<Long> ids) {
        return ids;
    }

}
