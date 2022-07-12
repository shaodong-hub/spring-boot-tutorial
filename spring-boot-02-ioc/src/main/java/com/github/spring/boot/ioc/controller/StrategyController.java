package com.github.spring.boot.ioc.controller;

import com.github.spring.boot.ioc.pojo.SmsSendCommand;
import com.github.spring.boot.ioc.service.ISmsStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * create in 2022/7/11 21:33
 *
 * @author shishaodong
 * @version 0.0.1
 */
@RestController
@RequiredArgsConstructor
public class StrategyController {

    private final Map<String, ISmsStrategy> smsStrategyMap;

    @PostMapping("/sms/strategy/{type}")
    public String sms(@PathVariable String type, @RequestBody SmsSendCommand command) {
        return smsStrategyMap.getOrDefault(type, strategy -> "Default").doSend(command);
    }

}
