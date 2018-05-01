package com.sheng.example.springaop.model.arg;

import java.io.Serializable;

/**
 * @author huangy
 * @date 2018/1/13
 */
public class GroupVO implements Serializable {

    private String name;

    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "GroupVO{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
