package com.huang.yuan.dubbo.support;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author huangy on 2019-10-27
 */
@Component
public class Support {

    @PostConstruct
    public void func() {
        System.out.println("Support PostConstruct");
    }

    @PreDestroy
    public void funcPreDestroy() {
        System.out.println("Support funcPreDestroy");
    }
}
