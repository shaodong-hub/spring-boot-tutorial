package com.github.spring.boot.ioc.service;

import com.github.spring.boot.ioc.pojo.SmsSendCommand;

/**
 * create in 2022/7/11 21:35
 *
 * @author shishaodong
 * @version 0.0.1
 */
@FunctionalInterface
public interface ISmsStrategy {

    String doSend(SmsSendCommand command);

}
