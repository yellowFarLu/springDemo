package com.huang.yuan.api.model;

/**
 * @author huangy on 2018/9/29
 */
import com.huang.yuan.api.common.CodeEnum;

import java.io.Serializable;

/**
 * Created by wangtao on 2015/10/12.
 */
public class BaseResult implements Serializable {

    private static final long serialVersionUID = -2104553682634315041L;

    /**
     * 返回码，默认值为0
     */
    private int errorCode = CodeEnum.SUCCESS.getErrorCode();

    /**
     * 返回描叙，默认值为success
     */
    private String errorMessage = "success";


    public BaseResult(int errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public BaseResult() {
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return "BaseResult{" +
                "errorCode=" + errorCode +
                ", errorMessage='" + errorMessage + '\'' +
                '}';
    }

    public boolean isSuccess() {
        return errorCode == CodeEnum.SUCCESS.getErrorCode();
    }

}

