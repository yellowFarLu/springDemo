package com.aop.proxyfactorybean;

/**
 * @author huangy on 2020-05-05
 */
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
public class MyBeforeAop implements MethodBeforeAdvice {

    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("before aop ["+method.getName()+"] do sth...................");
    }
}

