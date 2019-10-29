package com.model;

import javax.annotation.PostConstruct;
import java.io.Serializable;

/**
 * @author huangy on 2019-10-27
 */
public class ScopeBean implements Serializable {

    @PostConstruct
    public void init() {
        System.out.println("我被初始化了");
    }
}
