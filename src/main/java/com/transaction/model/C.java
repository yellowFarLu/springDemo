package com.transaction.model;

/**
 * @author huangy on 2018/7/15
 */
public class C {

    private Integer cno;

    public Integer getCno() {
        return cno;
    }

    public void setCno(Integer cno) {
        this.cno = cno;
    }

    @Override
    public String toString() {
        return "C{" +
                "cno=" + cno +
                '}';
    }
}
