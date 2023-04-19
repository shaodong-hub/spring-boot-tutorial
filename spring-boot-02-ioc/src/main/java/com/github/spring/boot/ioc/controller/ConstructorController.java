package com.github.spring.boot.ioc.controller;

import com.github.spring.boot.ioc.pojo.SmsSendCommand;
import com.github.spring.boot.ioc.service.SmsStrategyChinaTelecom;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * create in 2022/7/11 21:50
 *
 * @author shishaodong
 * @version 0.0.1
 */
//@RestController
@RequiredArgsConstructor
public class ConstructorController {

    @Resource
    private SmsStrategyChinaTelecom chinaTelecom;

    @PostMapping("simple/chinaTelecom")
    public String chinaTelecom(@RequestBody SmsSendCommand command) {
        return chinaTelecom.doSend(command);
    }

}
