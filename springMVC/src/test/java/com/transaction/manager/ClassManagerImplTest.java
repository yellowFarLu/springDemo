package com.transaction.manager;

import com.sheng.example.springaop.SpringTestCase;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * @author huangy on 2018/7/15
 */
public class ClassManagerImplTest extends SpringTestCase {

    @Resource
    private ClassManagerImpl classManager;
    @Resource
    private Jedis jedis;

    @Test
    public void insertClassForn() throws Exception {
        classManager.insertClassForn(5);
    }

    @Test
    public void testGetRedisKey() {
        print(jedis.get("123456789"));
    }
}