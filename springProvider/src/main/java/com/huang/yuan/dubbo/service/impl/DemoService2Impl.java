package com.huang.yuan.dubbo.service.impl;

import com.huang.yuan.api.service.DemoService2;
import org.springframework.stereotype.Service;

/**
 * @author huangy on 2018/10/6
 */
@Service
public class DemoService2Impl implements DemoService2 {

    @Override
    public void demoTest(String a) {
        System.out.printf(a);
    }
}
