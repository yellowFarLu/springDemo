package com.huang.yuan.dubbo;

import com.alibaba.dubbo.config.ProtocolConfig;
import org.springframework.web.context.ContextLoaderListener;

import javax.servlet.ServletContextEvent;

/**
 * @author huangy on 2019-12-02
 */
public class MyContextLoaderListener extends ContextLoaderListener {

    @Override
    public void contextDestroyed(ServletContextEvent event) {

        super.contextDestroyed(event);

        // 执行dubbo的优雅停机

    }
}
