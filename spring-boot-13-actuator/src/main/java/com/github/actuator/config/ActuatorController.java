package com.github.actuator.config;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 创建时间为 15:38-2019-03-21
 * 项目名称 SpringBootActuator
 * </p>
 *
 * @author shao
 * @version 0.0.1
 * @since 0.0.1
 */


@RestController
public class ActuatorController {

    @GetMapping("/hello")
    public String getHello() {
        return "hello";
    }

}
