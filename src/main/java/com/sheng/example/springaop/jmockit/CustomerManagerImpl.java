package com.sheng.example.springaop.jmockit;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author huangy
 * @date 2018/1/13
 */
@Service
public class CustomerManagerImpl implements CustomerManager {

    private CustomerDAO customerDAO;

    @Override
    public void save(String name) {
        customerDAO.save(name);
    }

    public CustomerDAO getCustomerDAO() {
        return customerDAO;
    }

    public void setCustomerDAO(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }
}
