package com.sheng.example.springaop.service.impl;

import com.sheng.example.springaop.service.AOPService;
import org.springframework.stereotype.Service;

/**
 * Created by Dell on 2017/1/20.
 */
@Service
public class AOPServiceImpl implements AOPService {
    @Override
    public String aoptest() {
        return "aoptest";
    }
}
