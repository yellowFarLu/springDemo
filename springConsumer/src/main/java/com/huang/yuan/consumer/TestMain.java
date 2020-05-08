package com.huang.yuan.consumer;

import com.alibaba.dubbo.rpc.service.GenericService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author huangy on 2020-04-08
 */
public class TestMain {

    /**
     * Spring泛化调用
     */
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("classpath:/spring/applicationContext.xml");
        context.start();

        GenericService demoService = (GenericService) context.getBean("demoService");

        Object result = demoService.$invoke(
                "test", new String[] { "java.lang.String" }, new Object[]{"黄远，你好"});

        System.out.println(result);
    }

}
