package cglib;

import com.huang.yuan.dubbo.cglibaop.SampleBean;
import com.huang.yuan.dubbo.cglibaop.SampleClass;
import net.sf.cglib.beans.ImmutableBean;
import net.sf.cglib.proxy.CallbackHelper;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.FixedValue;
import net.sf.cglib.proxy.NoOp;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * @author huangy on 2019-10-27
 */
public class TestCGLibDemo {

    @Test
    public void testImmutableBean() throws Exception {

        SampleBean bean = new SampleBean();
        bean.setValue("Hello world");

        //创建不可变类
        SampleBean immutableBean = (SampleBean) ImmutableBean.create(bean);
        Assert.assertEquals("Hello world",immutableBean.getValue());

        // 可以通过底层对象来进行修改
        bean.setValue("Hello world, again");
        Assert.assertEquals("Hello world, again", immutableBean.getValue());

        // 直接修改将throw exception
        immutableBean.setValue("Hello cglib");
    }

    @Test
    public void testCallbackFilter() throws Exception{

        Enhancer enhancer = new Enhancer();

        CallbackHelper callbackHelper = new CallbackHelper(SampleClass.class, new Class[0]) {

            @Override
            protected Object getCallback(Method method) {

                if((method.getDeclaringClass() != Object.class) &&
                        (method.getReturnType() == String.class)){

                    return new FixedValue() {
                        @Override
                        public Object loadObject() throws Exception {
                            return "Hello cglibxxxxxxx";
                        }
                    };

                }else{
                    return NoOp.INSTANCE;
                }
            }
        };

        enhancer.setSuperclass(SampleClass.class);
        enhancer.setCallbackFilter(callbackHelper);
        enhancer.setCallbacks(callbackHelper.getCallbacks());
        SampleClass proxy = (SampleClass) enhancer.create();

        // 拦截
        System.out.println(proxy.test("abc"));

        // 放行
        System.out.println(proxy.hashCode());
    }

}
