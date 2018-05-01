package com.sheng.example.springaop.jmockit;

import org.springframework.stereotype.Repository;

/**
 * @author huangy
 * @date 2018/1/13
 */
@Repository
public class CustomerDAOImpl implements CustomerDAO {

    @Override
    public int save(String name) {
        return 1;
    }
}
