package com.model;

/**
 * @author huangy on 2019-08-30
 */
public class DemoB {

    public DemoB() {
        System.out.println("调用了B的构造函数");
    }

    private DemoA demoA;

    public void setDemoA(DemoA demoA) {
        this.demoA = demoA;
    }
}
