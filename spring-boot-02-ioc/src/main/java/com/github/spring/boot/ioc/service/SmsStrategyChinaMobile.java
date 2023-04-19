package com.github.spring.boot.ioc.service;

import com.github.spring.boot.ioc.pojo.SmsSendCommand;
import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * create in 2022/7/11 21:35
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Slf4j
//@Component("ChinaMobile")
@AllArgsConstructor
public class SmsStrategyChinaMobile implements ISmsStrategy {

    @Resource
    private SmsStrategyChinaTelecom chinaTelecom;

    @Override
    public String doSend(SmsSendCommand command) {
        log.info("ChinaMobile {}", command);
        return "ChinaMobile";
    }
}
