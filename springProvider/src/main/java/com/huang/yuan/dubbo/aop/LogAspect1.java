package com.huang.yuan.dubbo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author huangy on 2019-04-14
 */
@Component
public class LogAspect1 {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogAspect1.class);

    public Object around(ProceedingJoinPoint point) throws Throwable {
        Object result;

        LOGGER.info("begin aop1");

        result = point.proceed();

        LOGGER.info("end aop1");

        return result;
    }

}
