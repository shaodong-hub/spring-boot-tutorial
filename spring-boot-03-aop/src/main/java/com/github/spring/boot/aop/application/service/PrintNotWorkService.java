package com.github.spring.boot.aop.application.service;

import com.github.spring.boot.aop.application.ArgsCommand;
import com.github.spring.boot.aop.infrastructure.annotation.Print;
import org.springframework.stereotype.Service;

/**
 * create in 2022/7/29 00:21
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Service
public class PrintNotWorkService {

    public int div5NotWork(ArgsCommand command){
        return extracted(command);
    }

    @Print("demo02")
    private int extracted(ArgsCommand command) {
        return 100 / command.getNumber();
    }

}
