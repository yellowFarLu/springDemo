package com.sheng.example.springaop.service;

import com.sheng.example.springaop.dao.DAO;

/**
 * @author huangy
 * @date 2018/1/13
 */
public class Service {

    private DAO dao;

    public void setDao(DAO dao) {
        this.dao = dao;
    }
}
