package com.github.spring.boot.ioc.controller;

import com.github.spring.boot.ioc.pojo.SmsSendCommand;
import com.github.spring.boot.ioc.service.SmsStrategyChinaMobile;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * create in 2022/7/11 21:50
 *
 * @author shishaodong
 * @version 0.0.1
 */
@RestController
public class ResourceController {

    @Resource
    private SmsStrategyChinaMobile chinaMobile;

    @PostMapping("simple/chinaMobile")
    public String chinaMobile(@RequestBody SmsSendCommand command) {
        return chinaMobile.doSend(command);
    }

}
