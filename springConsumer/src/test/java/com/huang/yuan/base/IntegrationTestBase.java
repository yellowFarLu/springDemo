package com.huang.yuan.base;

import com.alibaba.fastjson.JSON;
import org.junit.Ignore;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author huangy on 2018/9/29
 */
@Ignore
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/spring/applicationContext.xml")
public class IntegrationTestBase extends AbstractJUnit4SpringContextTests {

    public void print(Object result) {
        System.err.println("--------------------start----------------------------------");
        System.err.println("result:" +  JSON.toJSONString(result));
        System.err.println("--------------------end------------------------------------");
    }

    public void log(Object result) {
        logger.debug("--------------------start----------------------------------");
        logger.debug("result:" + result);
        logger.debug("--------------------end------------------------------------");
    }
}
