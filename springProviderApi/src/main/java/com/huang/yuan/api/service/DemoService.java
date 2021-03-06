package com.huang.yuan.api.service;

import com.huang.yuan.api.model.ModelResult;

import java.util.concurrent.CompletableFuture;

/**
 * @author huangy on 2018/9/29
 */
public interface DemoService {

    ModelResult<String> test(String param);

    String toString();

    int hashCode();

    boolean equals(Integer arg);
}
