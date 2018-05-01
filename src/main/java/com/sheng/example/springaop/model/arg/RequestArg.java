package com.sheng.example.springaop.model.arg;

import java.io.Serializable;

/**
 * @author huangy
 * @date 2017/12/8
 */
public class RequestArg implements Serializable {

    private static final long serialVersionUID = 5840592085589852741L;

    private String wxOpenId;

    public String getWxOpenId() {
        return wxOpenId;
    }

    public void setWxOpenId(String wxOpenId) {
        this.wxOpenId = wxOpenId;
    }

    @Override
    public String toString() {
        return "RequestArg {" +
                "wxOpenId=" + this.getWxOpenId() +
                "}";
    }
}
