package com.sheng.example.springaop.service;

import com.sheng.example.springaop.model.Result;

/**
 * @author huangy
 * @date 2018/1/13
 */
public interface MailService {

    Result send(String str1, String str2, String str3);

}
