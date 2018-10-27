package com.sheng.example.springaop.model.arg;

import com.sheng.example.springaop.model.Payment;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author huangy
 * @date 2018/3/16
 */
public class SaveCustomFieldArg implements Serializable {

    private String fsEa;

    List<Map<String, Object>> paymentField;

    public String getFsEa() {
        return fsEa;
    }

    public void setFsEa(String fsEa) {
        this.fsEa = fsEa;
    }

    public List<Map<String, Object>> getPaymentField() {
        return paymentField;
    }

    public void setPaymentField(List<Map<String, Object>> paymentField) {
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
