package com.sheng.example.springaop.model;

import java.io.Serializable;
import java.util.List;

/**
 * @author huangy
 * @date 2018/3/16
 */
public class Payment implements Serializable {

    private String fsEa;

    private String paymentType;

    private String name;

    private Boolean isOpen;

    private List<CustomField> orderPaymentFieldList;

    public String getFsEa() {
        return fsEa;
    }

    public void setFsEa(String fsEa) {
        this.fsEa = fsEa;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(Boolean isOpen) {
        this.isOpen = isOpen;
    }

    public List<CustomField> getOrderPaymentFieldList() {
        return orderPaymentFieldList;
    }

    public void setOrderPaymentFieldList(List<CustomField> orderPaymentFieldList) {
        this.orderPaymentFieldList = orderPaymentFieldList;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "fsEa='" + fsEa + '\'' +
                ", paymentType='" + paymentType + '\'' +
                ", name='" + name + '\'' +
                ", isOpen=" + isOpen +
                ", orderPaymentFieldList=" + orderPaymentFieldList +
                '}';
    }
}
