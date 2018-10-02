package com.huang.yuan.test;

import com.huang.yuan.api.service.DemoService;
import com.huang.yuan.base.IntegrationTestBase;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * @author huangy on 2018/9/29
 */
public class TestSpring extends IntegrationTestBase {

    @Resource
    private DemoService demoService;

    @Test
    public void test() {
        print(demoService.test("huangyuan"));
    }

    @Test
    public void testString() {
        print(demoService.toString());
    }

    @Test
    public void testHashCode() {
        print(demoService.hashCode());
    }

    @Test
    public void testEquals() {
        print(demoService.equalssss(1));
    }
}
