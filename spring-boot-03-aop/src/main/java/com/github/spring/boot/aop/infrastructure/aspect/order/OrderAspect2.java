package com.github.spring.boot.aop.infrastructure.aspect.order;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * create in 2022/7/13 21:51
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Slf4j
@Order(2)
@Aspect
@Component
public class OrderAspect2 {

    /**
     * 抽取公共的切入点表达式
     * 1.本类的引用
     * 2.其他的切面引用
     */
    @Pointcut("execution(* com.github.spring.boot.aop.application.service.*.*(..))")
    public void pointCut() {
    }

    /**
     * 环绕通知:手动引导代码执行
     *
     * @param pdj 可执行体
     * @return return
     * @throws Throwable Throwable
     */
    @Around(value = "pointCut()")
    public Object logAround(ProceedingJoinPoint pdj) throws Throwable {
        log.info("OrderAspect - 2 - logAround...运行...参数列表是:{}", Arrays.asList(pdj.getArgs()));
        return pdj.proceed();
    }


}
