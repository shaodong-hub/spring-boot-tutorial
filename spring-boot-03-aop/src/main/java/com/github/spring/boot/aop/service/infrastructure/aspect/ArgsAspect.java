package com.github.spring.boot.aop.service.infrastructure.aspect;

import com.github.spring.boot.aop.service.application.ArgsCommand;
import com.github.spring.boot.aop.service.infrastructure.annotation.Print;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * create in 2022/7/13 21:25
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Slf4j
@Aspect
@Component
public class ArgsAspect {

    @Around(value = "@annotation(print) && args(data)")
    public Object logAround(ProceedingJoinPoint pjp, ArgsCommand data, Print print) throws Throwable {
        Object response = pjp.proceed();
        log.info("有 @Print 注解,并且 参数类型为 ArgsCommand 才会打印 - {}", print.value());
        return response;
    }
}
