package com.huang.yuan.test;

import com.alibaba.dubbo.rpc.RpcContext;
import com.huang.yuan.api.model.ModelResult;
import com.huang.yuan.api.service.DemoService;
import com.huang.yuan.base.IntegrationTestBase;
import com.huang.yuan.consumer.TestService;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.concurrent.CompletableFuture;

/**
 * @author huangy on 2018/9/29
 */
public class TestSpring extends IntegrationTestBase {

    @Resource
    private DemoService demoService;
//    @Resource
//    private TestService testService;

    @Test
    public void testdada() throws Exception {

        RpcContext.getContext().asyncCall(() -> {
            System.out.println("开始");
            demoService.test("huangyuan");
            System.out.println("立即返回");
        });

        Thread.sleep(1000000);
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
        print(demoService.equals(1));
    }

//    @Test
//    public void testSSS() {
//        testService.test();
//    }
}
