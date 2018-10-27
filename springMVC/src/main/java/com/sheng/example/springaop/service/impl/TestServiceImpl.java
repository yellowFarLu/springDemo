package com.sheng.example.springaop.service.impl;

import com.sheng.example.springaop.service.TestService;
import org.springframework.stereotype.Service;

/**
 * @author huangy
 * @date 2017/12/22
 */
@Service
public class TestServiceImpl implements TestService {

    @Override
    public void test() {
        test1();
    }

    public void test1 () {
        throw new RuntimeException("Test RuntimeException");
    }
}
