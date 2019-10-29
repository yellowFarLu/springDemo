package com.huang.yuan.dubbo.jdkaop;


/**
 * RealSubject
 * 真实主题类
 **/
public class RealSubject implements Subject {
    @Override
    public void doSomething() {
        System.out.println("RealSubject do something");
    }
}