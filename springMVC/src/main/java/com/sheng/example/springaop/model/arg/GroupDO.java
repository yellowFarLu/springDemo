package com.sheng.example.springaop.model.arg;

import java.io.Serializable;

/**
 * @author huangy
 * @date 2018/1/13
 */
public class GroupDO implements Serializable {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "GroupDO{" +
                "name='" + name + '\'' +
                '}';
    }
}
