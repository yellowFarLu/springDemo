package com.huang.yuan.consumer;

import com.huang.yuan.api.service.DemoService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author huangy on 2018/10/10
 */
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private DemoService2 demoServiceYuan;

    @Override
    public void test() {
        System.out.println("哈哈哈");
    }
}
