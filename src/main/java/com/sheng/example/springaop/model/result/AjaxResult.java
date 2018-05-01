package com.sheng.example.springaop.model.result;

import java.io.Serializable;

/**
 * @author huangy
 * @date 2018/3/12
 */
public class AjaxResult implements Serializable {
    private static final long serialVersionUID = -3722436101234169306L;

    private Integer errCode = 0;
    private String errMsg = "OK";
    private Object data;

    public AjaxResult(Integer errCode, String errMsg) {
        this(errCode, errMsg, null);
    }

    public AjaxResult(Object data) {
        this(0, "OK", data);
    }

    public AjaxResult(Integer errCode, String errMsg, Object data) {
        this.errCode = errCode;
        this.errMsg = errMsg;
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Integer getErrCode() {
        return errCode;
    }

    public void setErrCode(Integer errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    @Override
    public String toString() {
        return "AjaxResult [errCode=" + errCode + ", errMsg=" + errMsg + ", data=" + data + "]";
    }
}
