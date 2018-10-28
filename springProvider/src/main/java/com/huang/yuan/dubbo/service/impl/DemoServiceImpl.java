package com.huang.yuan.dubbo.service.impl;

import com.huang.yuan.api.model.ModelResult;
import com.huang.yuan.api.service.DemoService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Random;

/**
 * @author huangy on 2018/9/29
 */
@Service
public class DemoServiceImpl implements DemoService {

    private Random random = new Random();

    @Override
    public ModelResult<String> test(String param) {
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

    @Override
    public Object addAll(Object result, Object s2) {
        return (String)result + (String) s2;
    }
}
