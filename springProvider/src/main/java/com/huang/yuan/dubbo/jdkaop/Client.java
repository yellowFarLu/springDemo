package com.huang.yuan.dubbo.jdkaop;

import com.huang.yuan.dubbo.jdkaop.JDKDynamicProxy;
import com.huang.yuan.dubbo.jdkaop.RealSubject;
import com.huang.yuan.dubbo.jdkaop.Subject;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Client
 * client测试代码
 **/
public class Client {

    static {
        // 保存生成的代理类的字节码文件
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
    }

    public static void main(String[] args) throws Exception {

        // 被代理类实例
        RealSubject realSubject = new RealSubject();

        // handler实例（请求会被转发到handler中）
        InvocationHandler handler = new JDKDynamicProxy(realSubject);

        // jdk动态代理
        Subject subject = (Subject) Proxy.newProxyInstance(RealSubject.class.getClassLoader(),
                RealSubject.class.getInterfaces(), handler);

        subject.doSomething();

    }
}