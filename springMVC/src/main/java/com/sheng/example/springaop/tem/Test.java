package com.sheng.example.springaop.tem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author huangy
 * @date 2018/1/12
 */
public abstract class Test {

    private static final Logger LOGGER = LoggerFactory.getLogger(Test.class);

    public void test() {
        LOGGER.warn("test abstract");
    }
}
