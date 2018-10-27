package com.sheng.example.springaop.model;

import java.io.Serializable;

/**
 * @author huangy
 * @date 2018/1/13
 */
public class Result implements Serializable {

    private String result;

    public Result(String string) {
        this.result = string;
    }

    @Override
    public String toString() {
        return result;
    }
}
