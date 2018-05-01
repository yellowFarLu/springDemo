package com.sheng.example.springaop.jmockit;

import java.io.Serializable;

/**
 * @author huangy
 * @date 2018/4/15
 */
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Work {
    private OtherVO otherVO;
    private ExecutorService executor = Executors.newFixedThreadPool(4);

    public void task() {
        executor.execute(new Runnable() {
            public void run() {
                System.out.println(otherVO.getValue());
            }
        });
    }
}
