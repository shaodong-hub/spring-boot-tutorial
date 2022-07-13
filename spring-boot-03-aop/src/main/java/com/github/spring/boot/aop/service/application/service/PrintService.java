package com.github.spring.boot.aop.service.application.service;

import com.github.spring.boot.aop.service.application.ArgsCommand;
import com.github.spring.boot.aop.service.application.DivCommand;
import com.github.spring.boot.aop.service.infrastructure.annotation.Print;
import org.springframework.stereotype.Service;

/**
 * create in 2022/7/13 21:27
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Service
public class PrintService {

    @Print("demo01")
    public int div1(DivCommand command) {
        return 100 / command.getNumber();
    }

    public int div2(DivCommand command) {
        return 100 / command.getNumber();
    }

    public int div3(ArgsCommand command) {
        return 100 / command.getNumber();
    }

    @Print("demo02")
    public int div4(ArgsCommand command) {
        return 100 / command.getNumber();
    }

}
