package com.github.spring.boot.aop.service.application.service;

import com.github.spring.boot.aop.service.application.DivCommand;
import org.springframework.stereotype.Service;

/**
 * create in 2022/7/13 21:02
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Service
public class DivService {
    public int div(DivCommand command) {
        return 100 / command.getNumber();
    }

}
