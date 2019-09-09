package com.model;

/**
 * @author huangy on 2019-08-30
 */
public class DemoA {

    public DemoA() {
        System.out.println("调用了A的构造函数");
    }

    private DemoB demoB;

    public void setDemoB(DemoB demoB) {
        this.demoB = demoB;
    }
}
