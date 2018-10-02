package com.huang.yuan.dubbo.component;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * @author huangy on 2018/10/2
 */
@Component
public class YuanProperPostProcesssor implements InstantiationAwareBeanPostProcessor {

    @Nullable
    @Override
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        return pvs;
    }
}
