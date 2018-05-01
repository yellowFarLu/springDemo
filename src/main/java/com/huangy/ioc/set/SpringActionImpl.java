package com.huangy.ioc.set;

import com.sheng.example.springaop.service.SpringAction;
import org.springframework.stereotype.Service;

/**
 * @author huangy on 2018/4/21
 */
@Service
public class SpringActionImpl implements SpringAction {

    private SpringDao springDao;

    public void setSpringDao(SpringDao springDao) {
        this.springDao = springDao;
    }

    public SpringDao getSpringDao() {
        return springDao;
    }
}
