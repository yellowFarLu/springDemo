//package com.huang.yuan.consumer;
//
//import com.alibaba.dubbo.rpc.cluster.Merger;
//import com.huang.yuan.api.model.ModelResult;
//
///**
// * @author huangy on 2018/10/28
// */
//public class MyMerger implements Merger<ModelResult> {
//
//    @Override
//    public ModelResult merge(ModelResult... items) {
//
//        ModelResult result = new ModelResult();
//        for (ModelResult item : items) {
//            // 进行数据合并操作
//            result.setResult((String)result.getResult() + (String) item.getResult());
//        }
//
//        return result;
//    }
//}
