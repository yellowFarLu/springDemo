package com.huang.yuan.test;

/**
 * @author huangy on 2018/11/12
 */

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.rpc.*;
import com.alibaba.dubbo.rpc.cluster.Directory;
import com.alibaba.dubbo.rpc.cluster.LoadBalance;
import com.alibaba.dubbo.rpc.cluster.directory.StaticDirectory;
import com.alibaba.dubbo.rpc.cluster.support.AbstractClusterInvoker;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

/**
 * AbstractClusterInvokerTest
 */
@SuppressWarnings("rawtypes")
public class MockInvokerTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MockInvokerTest.class);

    List<Invoker<IHelloService>> invokers = new ArrayList<Invoker<IHelloService>>();
    List<Invoker<IHelloService>> selectedInvokers = new ArrayList<Invoker<IHelloService>>();
    AbstractClusterInvoker<IHelloService> cluster;
    AbstractClusterInvoker<IHelloService> cluster_nocheck;
    Directory<IHelloService> dic;
    RpcInvocation invocation = new RpcInvocation();
    URL url = URL.valueOf("registry://localhost:9090");

    Invoker<IHelloService> invoker1;
    Invoker<IHelloService> invoker2;
    Invoker<IHelloService> invoker3;
    Invoker<IHelloService> invoker4;
    Invoker<IHelloService> invoker5;
    Invoker<IHelloService> mockedInvoker1;


    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @SuppressWarnings({"unchecked"})
    @Before
    public void setUp() throws Exception {
        invocation.setMethodName("sayHello");

        invoker1 = mock(Invoker.class);
        invoker2 = mock(Invoker.class);
        invoker3 = mock(Invoker.class);
        invoker4 = mock(Invoker.class);
        invoker5 = mock(Invoker.class);
        mockedInvoker1 = mock(Invoker.class);

        URL turl = URL.valueOf("test://test:11/test");

        given(invoker1.isAvailable()).willReturn(false);
        given(invoker1.getInterface()).willReturn(IHelloService.class);
        given(invoker1.getUrl()).willReturn(turl.addParameter("name", "invoker1"));

        given(invoker2.isAvailable()).willReturn(true);
        given(invoker2.getInterface()).willReturn(IHelloService.class);
        given(invoker2.getUrl()).willReturn(turl.addParameter("name", "invoker2"));

        given(invoker3.isAvailable()).willReturn(false);
        given(invoker3.getInterface()).willReturn(IHelloService.class);
        given(invoker3.getUrl()).willReturn(turl.addParameter("name", "invoker3"));

        given(invoker4.isAvailable()).willReturn(true);
        given(invoker4.getInterface()).willReturn(IHelloService.class);
        given(invoker4.getUrl()).willReturn(turl.addParameter("name", "invoker4"));

        given(invoker5.isAvailable()).willReturn(false);
        given(invoker5.getInterface()).willReturn(IHelloService.class);
        given(invoker5.getUrl()).willReturn(turl.addParameter("name", "invoker5"));

        given(mockedInvoker1.isAvailable()).willReturn(false);
        given(mockedInvoker1.getInterface()).willReturn(IHelloService.class);
        given(mockedInvoker1.getUrl()).willReturn(turl.setProtocol("mock"));

        invokers.add(invoker1);
        dic = new StaticDirectory<>(url, invokers, null);
        cluster = new AbstractClusterInvoker(dic) {
            @Override
            protected Result doInvoke(Invocation invocation, List invokers, LoadBalance loadbalance)
                    throws RpcException {
                return null;
            }
        };

        cluster_nocheck = new AbstractClusterInvoker(dic, url.addParameterIfAbsent(Constants.CLUSTER_AVAILABLE_CHECK_KEY, Boolean.FALSE.toString())) {
            @Override
            protected Result doInvoke(Invocation invocation, List invokers, LoadBalance loadbalance)
                    throws RpcException {
                return null;
            }
        };

    }


    @Test
    public void testBindingAttachment() {
        final String attachKey = "attach";
        final String attachValue = "value";

        // setup attachment
        RpcContext.getContext().setAttachment(attachKey, attachValue);
        Map<String, String> attachments = RpcContext.getContext().getAttachments();
        Assert.assertTrue("set attachment failed!", attachments != null && attachments.size() == 1);

        cluster = new AbstractClusterInvoker(dic) {
            @Override
            protected Result doInvoke(Invocation invocation, List invokers, LoadBalance loadbalance)
                    throws RpcException {
                // attachment will be bind to invocation
                String value = invocation.getAttachment(attachKey);
                Assert.assertTrue("binding attachment failed!", value != null && value.equals(attachValue));
                return null;
            }
        };

        // invoke
        cluster.invoke(invocation);
    }

    private void initlistsize5() {
        invokers.clear();
        selectedInvokers.clear();//Clear first, previous test case will make sure that the right invoker2 will be used.
        invokers.add(invoker1);
        invokers.add(invoker2);
        invokers.add(invoker3);
        invokers.add(invoker4);
        invokers.add(invoker5);
    }

    /**
     * Test mock invoker selector works as expected
     */
    @Test
    public void testMockedInvokerSelect() {
        initlistsize5();
        invokers.add(mockedInvoker1);

        RpcInvocation mockedInvocation = new RpcInvocation();
        mockedInvocation.setMethodName("sayHello");
        mockedInvocation.setAttachment(Constants.INVOCATION_NEED_MOCK, "true");
        List<Invoker<IHelloService>> mockedInvokers = dic.list(mockedInvocation);
        Assert.assertEquals(1, mockedInvokers.size());

        List<Invoker<IHelloService>> invokers = dic.list(invocation);
        Assert.assertEquals(5, invokers.size());
    }

    public static interface IHelloService {
    }
}

