package com.huang.yuan.api.common;

/**
 * @author huangy on 2018/9/29
 */
public enum CodeEnum {

    SUCCESS(0, "success", "成功"),

    SERVER_BUSY(-1, "server is busy", "系统繁忙"),

    SYSTEM_ERROR(-2, "system error", "系统错误"),

    PARAMS_ERROR(-3, "params error", "参数错误"),
    ;
    private int errorCode;

    private String errorMessage;

    private String description;


    CodeEnum(int errorCode, String errorMessage, String description) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "CodeEnum{" +
                "errorCode=" + errorCode +
                ", errorMessage='" + errorMessage + '\'' +
                ", description='" + description + '\'' +
                "} " + super.toString();
    }
}

