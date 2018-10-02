package com.huang.yuan.dubbo.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author huangy on 2018/10/2
 */
//@Component
public class TestBean {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestBean.class);

    /**
     * 初始化完成后调用，相当于init-method
     */
//    @PostConstruct
    public void test() {
        LOGGER.info(this.toString());
    }

}
