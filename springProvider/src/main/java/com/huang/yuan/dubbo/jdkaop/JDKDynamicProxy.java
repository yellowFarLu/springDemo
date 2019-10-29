package com.huang.yuan.dubbo.jdkaop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author huangy on 2019-10-27
 */
public class JDKDynamicProxy implements InvocationHandler {

    private Object target;

    public JDKDynamicProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        if (true) {
            throw new RuntimeException();
        }

        System.out.println("Do something before");

        Object result = method.invoke(target, args);

        System.out.println("Do something after");

        return result;
    }
}