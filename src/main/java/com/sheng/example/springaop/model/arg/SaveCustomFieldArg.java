package com.sheng.example.springaop.model.arg;

import com.sheng.example.springaop.model.Payment;

import java.io.Serializable;
import java.util.List;

/**
 * @author huangy
 * @date 2018/3/16
 */
public class SaveCustomFieldArg implements Serializable {

    private String fsEa;

    List<Payment> paymentField;

    public String getFsEa() {
        return fsEa;
    }

    public void setFsEa(String fsEa) {
        this.fsEa = fsEa;
    }

    public List<Payment> getPaymentField() {
        return paymentField;
    }

    public void setPaymentField(List<Payment> paymentField) {
        this.paymentField = paymentField;
    }

    @Override
    public String toString() {
        return "SaveCustomFieldArg{" +
                "fsEa='" + fsEa + '\'' +
                ", paymentField=" + paymentField +
                '}';
    }
}
