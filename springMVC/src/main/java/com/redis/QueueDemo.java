package com.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import java.util.Set;

/**
 * 延时队列案例
 * @author huangy on 2018/8/26
 */
@Component
public class QueueDemo {

    private static final Logger LOGGER = LoggerFactory.getLogger(QueueDemo.class);

    @Resource
    private Jedis jedis;

    private static final String QUEUE_KEY = "queueKey";

    /**
     * 将任务扔到延时队列中
     * 使用时间作为score
     * @param msg 任务（一般使用json格式的字符串）
     */
    public void delay(String msg) {
        jedis.zadd(QUEUE_KEY, System.currentTimeMillis() + 5000, msg);
    }

    /**
     * 从延时队列中获取任务，利用时间范围作为score的范围
     * zrangeByScore ：返回有序集 key 中，所有 score 值介于 min 和 max 之间(包括等于 min 或 max )的成员
     */
    public void loop() {
        while (!Thread.interrupted()) {
            Set<String> values = jedis.zrangeByScore(QUEUE_KEY,SpringContainer
                    0, 577742424, 0, 1);
            if (values.isEmpty()) {
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    LOGGER.error("loop sleep fail", e);
                    break;
                }

                continue;
            }

            String s = values.iterator().next();
            // 利用zrem判断是否拿到任务
            if (jedis.zrem(QUEUE_KEY, s) > 0) {
                // 拿到这个任务了，进行处理
                LOGGER.info("loop msg, msg={}", s);
            }
        }
    }
}
