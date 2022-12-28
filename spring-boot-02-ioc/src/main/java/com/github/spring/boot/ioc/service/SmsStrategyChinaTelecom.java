package com.github.spring.boot.ioc.service;

import com.github.spring.boot.ioc.pojo.SmsSendCommand;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * create in 2022/7/11 21:35
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Slf4j
//@Component("ChinaTelecom")
@AllArgsConstructor
public class SmsStrategyChinaTelecom implements ISmsStrategy {

    @Resource
    private SmsStrategyChinaMobile chinaMobile;

    @Override
    public String doSend(SmsSendCommand command) {
        log.info("ChinaTelecom {}", command);
        return "ChinaTelecom";
    }
}
