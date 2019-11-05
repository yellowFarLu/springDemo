package com.huang.yuan.dubbo;

import java.util.concurrent.CompletableFuture;

/**
 * @author huangy on 2019-11-04
 */
public interface AsyncService {

    CompletableFuture<String> sayHello(String name);

}
