package com.huang.yuan.dubbo.cglibaop;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author huangy on 2019-10-27
 */
public class DaoProxy implements MethodInterceptor {

    @Override
    public Object intercept(Object object, Method method, Object[] objects, MethodProxy proxy)
            throws Throwable {

        System.out.println("Before Method Invoke");

        proxy.invokeSuper(object, objects);

        System.out.println("After Method Invoke");

        return object;
    }

}
