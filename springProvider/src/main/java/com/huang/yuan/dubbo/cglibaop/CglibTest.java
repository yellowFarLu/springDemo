package com.huang.yuan.dubbo.cglibaop;

import net.sf.cglib.proxy.Enhancer;

/**
 * @author huangy on 2019-10-27
 */
public class CglibTest {

    public static void main(String[] args) {

        // 生成代理类
        DaoProxy daoProxy = new DaoProxy();

        Enhancer enhancer = new Enhancer();
        // 代理类的父类
        enhancer.setSuperclass(Dao.class);
        // 设置代理类的调用处理器
        enhancer.setCallback(daoProxy);

        // 获取代理类
        Dao dao = (Dao)enhancer.create();
        dao.update();
        dao.select();
    }

}
