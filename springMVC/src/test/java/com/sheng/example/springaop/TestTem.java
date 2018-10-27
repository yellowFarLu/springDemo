package com.sheng.example.springaop;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sheng.example.springaop.model.CustomerDO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author huangy
 * @date 2018/3/15
 */
public class TestTem {

    public static void main(String[] args) {
        List<CustomerDO> customerDOS = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            CustomerDO customerDO = new CustomerDO();
            customerDO.setAppId("appIdtest");
            customerDO.setGmtCreate(new Date());
            customerDO.setGroupId((long)i);
            customerDO.setIsDepartment(i);
            customerDOS.add(customerDO);
        }

        JSONArray jsonArray = (JSONArray) JSONObject.toJSON(customerDOS);

        String json = jsonArray.toString();

        System.out.println(json);

        List<CustomerDO> result = JSONArray.parseArray(json, CustomerDO.class);
        System.out.println(result);
    }

}
