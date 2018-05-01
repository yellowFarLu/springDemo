package com.sheng.example.springaop;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//指定bean注入的配置文件
@ContextConfiguration(locations = { "classpath:ApplicationContext.xml" })
//使用标准的JUnit @RunWith注释来告诉JUnit使用Spring TestRunner
@RunWith(SpringJUnit4ClassRunner.class)
public class SpringTestCase extends AbstractJUnit4SpringContextTests {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringTestCase.class);

    public void print(Object obj) {
        LOGGER.error("---------begin-----------");

        LOGGER.error(obj.toString());

        LOGGER.error("---------end-----------");
    }
}
