package com.huang.yuan.dubbo.adaptive;

import com.alibaba.dubbo.common.URL;

/**
 * @author huangy on 2019-10-29
 */
public class SpringAdaptiveExtImpl implements AdaptiveExt {

    @Override
    public String echo(String msg, URL url) {
        return "spring execute";
    }
}
