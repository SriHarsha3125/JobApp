package com.example.spring_boot_rest.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    private static final Logger loger = LoggerFactory.getLogger(LoggingAspect.class);
    // return type , classname.methodname(args)
    @Before("execution(* com.example.spring_boot_rest.service.JobService.getJob(..))")
    public void logMethodCall(JoinPoint jp){
        loger.info("Method Called " + jp.getSignature().getName() );
    }
    @After("execution(* com.example.spring_boot_rest.service.JobService.getJob(..))")
    public void logMethodExecute(JoinPoint jp){
        loger.info("Method Executed " + jp.getSignature().getName() );
    }
    @AfterThrowing("execution(* com.example.spring_boot_rest.service.JobService.getJob(..))")
    public void logMethodCrash(JoinPoint jp){
        loger.info("Method Called some issues " + jp.getSignature().getName() );
    }
    @AfterReturning("execution(* com.example.spring_boot_rest.service.JobService.getJob(..))")
    public void logMethodExecutedSuccess(JoinPoint jp){
        loger.info("Method Called was success " + jp.getSignature().getName() );
    }

}
