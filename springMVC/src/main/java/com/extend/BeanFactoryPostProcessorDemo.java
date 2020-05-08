package com.extend;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * @author huangy on 2019-09-02
 */
@Component
public class BeanFactoryPostProcessorDemo implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        // 获取bean定义
//        BeanDefinition beanDefinition =
//                beanFactory.getBeanDefinition("beanId");

        // 修改BeanDefinition，从而影响之后实例化的bean
        // ..
    }
}