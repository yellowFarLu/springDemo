package com.huang.yuan.dubbo.model;

import java.io.Serializable;

/**
 * @author huangy on 2018/11/9
 */
public class Bean2 implements Serializable {

    private Integer one;

    public Integer getOne() {
        return one;
    }

    public void setOne(Integer one) {
        this.one = one;
    }

    @Override
    public String toString() {
        return "Bean2{" +
                "one=" + one +
                '}';
    }
}
