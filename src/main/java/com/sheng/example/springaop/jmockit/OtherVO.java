package com.sheng.example.springaop.jmockit;

import java.io.Serializable;

/**
 * @author huangy
 * @date 2018/4/15
 */
public class OtherVO implements Serializable {

    private static final String str = null;

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
