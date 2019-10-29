package com.huang.yuan.dubbo.adaptive;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.Adaptive;

/**
 * @author huangy on 2019-10-29
 */
@Adaptive
public class DubboAdaptiveExtImpl implements AdaptiveExt {

    @Override
    public String echo(String msg, URL url) {
        return "dubbo execute";
    }
}
