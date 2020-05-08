package com.sheng.example.springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestAspect.class);

    public void doAfter(JoinPoint jp) {
        LOGGER.info("log Ending method: " + jp.getTarget().getClass().getName() + "." + jp.getSignature().getName());
    }

    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        long time = System.currentTimeMillis();
        Object retVal = pjp.proceed();
        time = System.currentTimeMillis() - time;
        LOGGER.info("process time: " + time + " ms");
        return retVal;
    }

    public void doBefore(JoinPoint jp) {
        LOGGER.info("log Begining method: " + jp.getTarget().getClass().getName() + "." + jp.getSignature().getName());
    }

    public void doThrowing(JoinPoint jp, Throwable ex) {
        LOGGER.info("method " + jp.getTarget().getClass().getName() + "." + jp.getSignature().getName() + " throw exception");
        LOGGER.info(ex.getMessage());
    }
}
