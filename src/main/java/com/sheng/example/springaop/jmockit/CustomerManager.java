package com.sheng.example.springaop.jmockit;

import com.sheng.example.springaop.dao.DAO;

/**
 * @author huangy
 * @date 2018/1/13
 */
public interface CustomerManager {

    CustomerDAO getCustomerDAO();

    void setCustomerDAO(CustomerDAO customerDAO);

    void save(String name);

}
