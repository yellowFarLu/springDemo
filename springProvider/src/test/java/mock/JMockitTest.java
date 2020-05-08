package mock;

import com.huang.yuan.dubbo.mock.PersonService;
import common.IntegrationTestBase;
import mockit.Expectations;
import mockit.Mocked;
import mockit.StrictExpectations;
import mockit.Verifications;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author huangy on 2020-02-23
 */
public class JMockitTest extends IntegrationTestBase {

    /**
     * 对整个PersonService对象进行mock，每一个mock方法都可以设置返回值，没有mock的方法返回值为null
     */
    @Test
    public void mockProcessTest(final @Mocked PersonService target) {

        //录制预期行为
        new Expectations() {
            {
                target.showName(anyString);
                result = "test1";
                target.showAge(anyInt);
                result = -1;
            }
        };

        //调用被测试代码，即回访
        System.out.println("test result =    " + target.showName("test2"));
        Assert.assertTrue("test1".equals(target.showName("test2")));
        Assert.assertTrue(-1 == target.showAge(12));
        Assert.assertTrue(-1 == target.showAge(12));

        //验证
        new Verifications() {
            {
                target.showName("test1");
                times = 0; //执行了0次。参数一致的才会计数
                target.showAge(12);
                times = 2; //执行了2次
            }
        };
    }

    /**
     * Expections中的方法至少被调用一次，否则会出现missing invocation错误.
     * 调用次数和调用顺序不限.
     */
    @Test
    public void mockExpectationsProcessTest(final @Mocked PersonService service){
        new Expectations() {{
            service.showAge(anyInt);
            result = -1;
        }};
        //只调用showName会报错 Missing 1 invocation（亲测不会报错。。。）
        service.showName("hahah");
        service.showAge(12);
    }

    /**
     * StrictExpectations中方法调用的次数和顺序都必须严格执行。如果出现了在StrictExpectations中没有声明的方法，会出现unexpected invocation错误。
     * 没有必要做Verifications验证。
     */
    @Test
    public void mockStrictExpectationsProcessTest(final @Mocked PersonService service) {
        new StrictExpectations(){{
            service.showAge(anyInt);
            result = -1;
            service.showName(anyString);
            result = "ok";
        }};

        //1.下面只执行了一个录制方法，报错：unexpected invocation, Missing invocation
        // Assert.assertTrue(-1 == service.showAge(12));

        //2.下面与录制顺序不一致，会报错：unexpected invocation, Missing invocation
        // Assert.assertTrue("ok".equals(service.showName("test")));
        // Assert.assertTrue(-1 == service.showAge(12));

        //3.调用没有录制的方法，报错 Unexpected invocation
        // service.getDefaultPerson();

        //必须全部执行录制的方法，且顺序一致
        Assert.assertTrue(-1 == service.showAge(12));
        Assert.assertTrue("ok".equals(service.showName("test")));
    }
}
