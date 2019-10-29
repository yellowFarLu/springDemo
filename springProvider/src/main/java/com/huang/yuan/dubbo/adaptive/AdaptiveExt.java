package com.huang.yuan.dubbo.adaptive;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.Adaptive;
import com.alibaba.dubbo.common.extension.SPI;

/**
 * @author huangy on 2019-10-29
 */
@SPI
public interface AdaptiveExt {

    @Adaptive
    String echo(String msg, URL url);
}
