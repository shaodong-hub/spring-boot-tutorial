package com.github.spring.boot.ioc.service;

import com.github.spring.boot.ioc.pojo.SmsSendCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * create in 2022/7/11 21:35
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Slf4j
@Component("AlibabaMobile")
public class SmsStrategyAliababa implements ISmsStrategy {

    @Override
    public String doSend(SmsSendCommand command) {
        log.info("AlibabaMobile {}", command);
        return "AlibabaMobile";
    }
}
