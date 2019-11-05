package com.huang.yuan.dubbo;

import org.junit.Test;

import javax.annotation.Resource;
import java.util.concurrent.CompletableFuture;

/**
 * @author huangy on 2018/9/29
 */
public class TestSpring extends IntegrationTestBase {

    @Resource
    private AsyncService asyncService;

    @Test
    public void testSayHello() throws Exception {

        // 调用直接返回CompletableFuture
        CompletableFuture<String> future = asyncService.sayHello("async call request");

        // 增加回调
        future.whenComplete((v, t) -> {
            if (t != null) {
                t.printStackTrace();
            } else {
                System.out.println("Response: " + v);
            }
        });

        // 早于结果输出
        System.out.println("Executed before response return.");

        Thread.sleep(100000);
    }
}
