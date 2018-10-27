package com.huang.yuan.consumer;

import org.springframework.stereotype.Service;

/**
 * @author huangy on 2018/10/10
 */
@Service
public class TestServiceImpl implements TestService {

    @Override
    public void test() {
        System.out.println("哈哈哈");
    }
}
