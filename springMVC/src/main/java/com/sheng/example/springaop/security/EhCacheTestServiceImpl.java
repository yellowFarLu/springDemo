package com.sheng.example.springaop.security;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author huangy
 * @date 2017/12/13
 */
@Service
public class EhCacheTestServiceImpl implements EhCacheTestService {

    /**
     * 如果找到 param 对应的键值对（param作为key），就不调用方法了
     * @param param
     * @return
     */
    @Cacheable(value="cacheTest",key="#param")
    public String getTimestamp(String param) {
        Long timestamp = System.currentTimeMillis();
        return timestamp.toString();
    }

}
