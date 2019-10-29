package com.model;

import java.io.Serializable;

/**
 * @author huangy on 2019-10-27
 */
public class Student implements Serializable {

    public Student(String abc) {
        this.abc = abc;
    }

    private String abc;

    public String getAbc() {
        return abc;
    }

    public void setAbc(String abc) {
        this.abc = abc;
    }

    @Override
    public String toString() {
        return "Student{" +
                "abc='" + abc + '\'' +
                '}';
    }
}
