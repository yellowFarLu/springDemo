package com.huang.yuan.api.model;

import java.io.Serializable;

/**
 * @author huangy on 2018/9/29
 */
public class ModelResult<T> extends BaseResult implements Serializable {

    private static final long serialVersionUID = -4342358707077776948L;

    private T result;

    public ModelResult() {
    }

    public ModelResult(int errorCode, String errorMessage) {
        super(errorCode, errorMessage);
    }

    public ModelResult(int errorCode, String errorMessage, T result) {
        super(errorCode, errorMessage);
        this.setResult(result);
    }

    public ModelResult(T result) {
        this.result = result;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "ModelResult{" +
                "result=" + result +
                "} " + super.toString();
    }
}