package com.sheng.example.springaop.model;

import java.io.Serializable;

/**
 * @author huangy
 * @date 2018/3/14
 */
public class CustomerPersonalStatistics extends CustomerDO implements Serializable {

    private Integer temCount1;

    private Integer temCount2;

    private Integer temCount3;

    public Integer getTemCount1() {
        return temCount1;
    }

    public void setTemCount1(Integer temCount1) {
        this.temCount1 = temCount1;
    }

    public Integer getTemCount2() {
        return temCount2;
    }

    public void setTemCount2(Integer temCount2) {
        this.temCount2 = temCount2;
    }

    public Integer getTemCount3() {
        return temCount3;
    }

    public void setTemCount3(Integer temCount3) {
        this.temCount3 = temCount3;
    }

    @Override
    public String toString() {
        return "CustomerPersonalStatistics{" +
                "temCount1=" + temCount1 +
                ", temCount2=" + temCount2 +
                ", temCount3=" + temCount3 +
                '}' + super.toString();
    }
}
