package com.transaction.dao;

import com.transaction.model.C;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author huangy on 2018/7/15
 */
public interface ClassDAO {
    public int add(C c);
}
