package com.model;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


/**
 * @author huangy on 2019-08-30
 */
public class BeanNameTestModel implements BeanNameAware, BeanFactoryAware, DisposableBean {

    public BeanNameTestModel() {
        System.out.println("执行到构造函数");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("BeanNameTestModel 在Spring里面的名字=" + name);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("BeanNameTestModel 调用了setBeanFactory, beanFactory=" + beanFactory);
    }

    @PostConstruct
    public void afterConstructDemo() {
        System.out.println("依赖注入完了，我该做点啥....");
    }

    public void initMethodDemo() {
        System.out.println("这是init方法");
    }

    @PreDestroy
    public void preDestoryDemo() {
        System.out.println("在注销前，我该做点啥....");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("执行DisposableBean的destroy方法");
    }

    public void destoryMethodDemo() {
        System.out.println("这是destoryMethodDemo方法");
    }
}
