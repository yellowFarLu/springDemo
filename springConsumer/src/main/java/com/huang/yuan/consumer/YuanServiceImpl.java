package com.huang.yuan.consumer;

import com.comsumer.service.YuanService;
import org.springframework.stereotype.Service;

/**
 * @author huangy on 2018/12/9
 */
@Service
public class YuanServiceImpl implements YuanService {

    @Override
    public void test() {
        System.out.println("YuanServiceImpl 哈哈");
    }
}
