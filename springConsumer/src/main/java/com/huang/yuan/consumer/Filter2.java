package com.huang.yuan.consumer;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.rpc.*;

import java.util.Map;

/**
 * @author huangy on 2018/12/23
 */
@Activate(order = 1)
public class Filter2 implements Filter {

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {

        Map<String, String> attachments = invocation.getAttachments();

        // 通过RETURN_KEY这个参数，表示调用不需要返回值
        attachments.put(Constants.RETURN_KEY, "false");

        return invoker.invoke(invocation);
    }
}
