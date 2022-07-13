package com.github.spring.boot.aop.infrastructure.aspect;

import com.github.spring.boot.aop.infrastructure.annotation.Print;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
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
public class PrintAspect {

    @Pointcut("@annotation(print)")
    public void pointCut(Print print) {
    }

    @Around(value = "pointCut(print)")
    public Object logAround(ProceedingJoinPoint pjp, Print print) throws Throwable {
        Object response = pjp.proceed();
        log.info("只有 @Print 注解才会打印 PrintAspect {} - {}", pjp.getSignature().getName(), print.value());
        return response;
    }


}
