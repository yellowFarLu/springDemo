package com.transaction.manager;

import com.transaction.dao.ClassDAO;
import com.transaction.model.C;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.Jedis;
//import redis.clients.jedis.Jedis;

import javax.annotation.Resource;

/**
 * @author huangy on 2018/7/15
 */
//@Service
public class ClassManagerImpl {

    @Resource
    private ClassDAO classDAO;
    @Resource
    private Jedis jedis;

    @Transactional
    public void insertClassForn(int n) throws Exception {

        for (int i = 0; i < n; i++) {

            C c = new C();
            c.setCno(i+1);
            classDAO.add(c);
        }

        jedis.set("123456789", "123456789");

        throw new RuntimeException();
    }
}
