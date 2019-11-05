package com.huang.yuan.dubbo;

import org.apache.dubbo.rpc.RpcContext;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

/**
 * @author huangy on 2019-11-04
 */
@Service
public class AsyncServiceImpl implements AsyncService {

    @Override
    public CompletableFuture<String> sayHello(String name) {

        /*
         * 通过return CompletableFuture.supplyAsync()，实现异步执行
         * 业务执行已从Dubbo线程切换到业务线程，避免了对Dubbo线程池的阻塞。
         */
        return CompletableFuture.supplyAsync(() -> {

            System.out.println("收到客户端的请求，name=" + name);

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return "async response from provider.";
        });
    }
}