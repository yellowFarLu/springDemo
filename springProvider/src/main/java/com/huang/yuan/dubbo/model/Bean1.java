package com.huang.yuan.dubbo.model;

import java.io.Serializable;

/**
 * @author huangy on 2018/11/9
 */
public class Bean1 implements Serializable {

    private Integer one;

    private Integer two;

    public Integer getOne() {
        return one;
    }

    public void setOne(Integer one) {
        this.one = one;
    }

    public Integer getTwo() {
        return two;
    }

    public void setTwo(Integer two) {
        this.two = two;
    }

    @Override
    public String toString() {
        return "Bean1{" +
                "one=" + one +
                ", two=" + two +
                '}';
    }
}
