package mock;

import com.google.common.collect.Lists;
import com.huang.yuan.dubbo.mock.CoderService;
import com.huang.yuan.dubbo.mock.Person;
import com.huang.yuan.dubbo.mock.PersonService;
import mockit.*;
import mockit.integration.junit4.JMockit;
import org.apache.commons.collections.CollectionUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Collection;
import java.util.List;

/**
 * @author huangy on 2020-02-23
 */
@RunWith(JMockit.class)
public class MockTest {

    //@Mocked 修饰，所有实例都会被mock
    @Mocked
    private PersonService personService;

    // @Injectable 修饰，只mock指定的实例。
    @Injectable
    private CoderService coderService;

    @Test
    public void testInstance() {
        new Expectations() {
            {
                personService.showAge(anyInt);
                result = -1;

                personService.getDefaultPerson();
                result = new Person("me", 4, null);

                Deencapsulation.invoke(coderService, "showWork", anyString);
                result = "java";

            }
        };

        //record的方法，按照给定的结果返回
        Assert.assertTrue(-1 == personService.showAge(11));
        Assert.assertTrue("java".equals(coderService.showWork("nothing")));
        Assert.assertTrue(4 == personService.getDefaultPerson().getAge());
        //没有录制的方法，返回默认值
        Assert.assertTrue(personService.showName("testName") == null);
        Assert.assertTrue(coderService.showSalary(100) == 0);

        //Mock 所有PersonServiceImpl实例
        PersonService pservice = new PersonService();
        Assert.assertTrue(-1 == pservice.showAge(11));
        Assert.assertTrue(pservice.showName("testName") == null);

        //新生成的CoderService实例没有被mock
        CoderService cservice = new CoderService();
        Assert.assertTrue("something".equals(cservice.showWork("something")));
        Assert.assertTrue(cservice.showSalary(100) == 100);
    }

    /**
     * 可以将参数注入，与类中注入结果一致。
     * 但是不要同时在参数中注入，且在测试类中注入，会影响执行结果。
     */
    @Test
    public void testInjectObj(final @Injectable CoderService coderService) {
        new Expectations() {
            {
                coderService.showWork(anyString);
                result = "ok";
            }
        };
        Assert.assertTrue("ok".equals(coderService.showWork("hello")));
        Assert.assertTrue(coderService.showSalary(100) == 0);
    }


    /**
     * 部分mock，在Expectations中传入被mock实例。
     * replay的方法在Expectations中被录制时，按照record结果返回；
     * 没有被录制，则调用原有代码
     */
    @Test
    public void partiallyMock(){
        new Expectations(personService) {
            {
                personService.showAge(anyInt);
                result = -1;
            }
        };
        //被录制的方法，按照record结果返回
        Assert.assertTrue(-1 == personService.showAge(11));
        //未录制的方法，调用原有代码
        Assert.assertTrue("testName".equals(personService.showName("testName")));
    }

    /**
     * mockUp类，被mock的方法，replay的时候都执行mock的方法；
     * 没有被mock的方法，调用原有代码
     */
    @Test
    public void mockUpTest(){

        new MockUp<PersonService>(){
            @Mock
            public String showName(String name){
                return "mocked";
            }
        };

        Assert.assertTrue("mocked".equals(new PersonService().showName("test")));
        Assert.assertTrue(0 == new PersonService().showAge(1));
    }

    /**
     * mock静态方法
     */
    @Test
    public void testStaticMethod(){

        new Expectations(CollectionUtils.class){{
            CollectionUtils.isEmpty((Collection<?>) any);
            result = true;
        }};

        List<Integer> list = Lists.newArrayList(1,2,3);

        Assert.assertTrue(list.size() == 3);
        Assert.assertTrue(CollectionUtils.isEmpty(list));
    }
}
