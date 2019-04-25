package com.huang.yuan.dubbo.service.impl;

import com.huang.yuan.api.model.ModelResult;
import com.huang.yuan.api.service.DemoService;
import com.huang.yuan.api.service.DemoService2;
import com.huang.yuan.dubbo.model.TestBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Random;

/**
 * @author huangy on 2018/9/29
 */
@Service
public class DemoServiceImpl implements DemoService {

    private static final Logger spLogger = LoggerFactory.getLogger("com.huang.yuan.dubbo.service.impl.DemoServiceImpl");

    private static final Logger orLogger = LoggerFactory.getLogger(DemoService2Impl.class);

    private Random random = new Random();

    @Resource
    private DemoService2 demoService2;

    @Override
    public ModelResult<String> test(String param) {
        spLogger.error("执行函数啦");
        return new ModelResult<>(param);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Integer arg) {
        return (random.nextInt(5) == 3);
    }
}
