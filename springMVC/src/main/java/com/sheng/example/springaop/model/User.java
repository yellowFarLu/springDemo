package com.sheng.example.springaop.model;

/**
 * @author huangy
 * @date 2017/12/8
 */
public class User {

    private String name;

    private String test;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    @Override
    public String toString() {
        return "User {" +
                "name=" + this.getName() +
                "}";
    }
}
