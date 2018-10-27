package com.sheng.example.springaop.param;

import java.util.List;

/**
 * @author huangy
 * @date 2017/12/14
 */
public class Test {
    private String one;
    private String two;
    private String three;

    private List<Integer> departments;

    private List<String> customerIds;

    public List<String> getCustomerIds() {
        return customerIds;
    }

    public void setCustomerIds(List<String> customerIds) {
        this.customerIds = customerIds;
    }

    public String getOne() {
        return one;
    }

    public void setOne(String one) {
        this.one = one;
    }

    public String getTwo() {
        return two;
    }

    public void setTwo(String two) {
        this.two = two;
    }

    public String getThree() {
        return three;
    }

    public void setThree(String three) {
        this.three = three;
    }

    public List<Integer> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Integer> departments) {
        this.departments = departments;
    }

    @Override
    public String toString() {
        return "Test {" +
                "one=" + this.one + '\'' +
                "two=" + this.two + '\'' +
                "three=" + this.three + '\'' +
                "departments=" + this.departments + '\'' +
                "customerIds=" + this.customerIds + '\'' +
                "}";
    }
}
