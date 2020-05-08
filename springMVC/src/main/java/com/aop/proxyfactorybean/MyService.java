package com.aop.proxyfactorybean;

/**
 * @author huangy on 2020-05-05
 */
import org.springframework.stereotype.Service;

@Service
public class MyService implements ServInter {

    public void say() {
        System.out.println("MyService say Hi");
    }
}
