package com.sheng.example.springaop.model;

import java.io.Serializable;

/**
 * @author huangy
 * @date 2018/3/16
 */
public class CustomField implements Serializable {

    private String fieldName;

    private String desc;

    private Boolean isMust;

    private Boolean isForbidden;

    private String showType;

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Boolean getIsMust() {
        return isMust;
    }

    public void setIsMust(Boolean must) {
        isMust = must;
    }

    public Boolean getIsForbidden() {
        return isForbidden;
    }

    public void setIsForbidden(Boolean forbidden) {
        isForbidden = forbidden;
    }

    public String getShowType() {
        return showType;
    }

    public void setShowType(String showType) {
        this.showType = showType;
    }

    @Override
    public String toString() {
        return "CustomField{" +
                "fieldName='" + fieldName + '\'' +
                ", desc='" + desc + '\'' +
                ", isMust=" + isMust +
                ", isForbidden=" + isForbidden +
                ", showType=" + showType +
                '}';
    }
}
