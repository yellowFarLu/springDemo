package mock;

import com.huang.yuan.dubbo.mock.CoderService;
import com.huang.yuan.dubbo.mock.Person;
import com.huang.yuan.dubbo.mock.PersonService;
import mockit.Deencapsulation;
import mockit.Expectations;
import mockit.Injectable;
import mockit.Tested;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author huangy on 2020-02-23
 */
public class CoderServiceTest {

    @Tested
    private CoderService coderService;
    @Injectable
    private PersonService personService;

    @Test
    public void testMockCase(){
        new Expectations(coderService){{
            //mock私有变量
            Deencapsulation.setField(coderService, "desc", "coderDesc");
            //mock 方法
            Deencapsulation.invoke(coderService, "showWork", anyString);
            result = "noWork";
        }};

        //mock 私有变量成功
        Assert.assertTrue(coderService.getDesc().equals("coderDesc"));
        //mock 私有方法
        Assert.assertTrue(coderService.showWork("coder").equals("noWork"));
    }

    @Test
    public void testParamCase() {
        new Expectations(coderService){{
            //基本类型，mock参数为anyXXX
            Deencapsulation.invoke(coderService, "showWork", anyString);
            result = "mocked";

            //基本类型，mock参数为实际值
            Deencapsulation.invoke(coderService, "showSalary", 12);
            result = -1;

            //非基本类型，mock参数不可以为anyXXX，会报错 java.lang.IllegalArgumentException: Invalid null value passed as argument 0
            //    Deencapsulation.invoke(coderService, "getPersonName", (Person)any);
            //    result = "mocked";

            //基本类型，mock参数为实际值
            Deencapsulation.invoke(
                    coderService, "getPersonName", new Person("me", 3, null));
            result = "mocked";
        }};

        //基本类型，mock参数为anyXXX, 实际参数为任意值mock成功
        Assert.assertTrue(coderService.showWork("java").equals("mocked"));

        //基本类型，mock参数为具体值, 实际参数 equals mock参数时，mock成功，否则调用原来的方法
        Assert.assertTrue(coderService.showSalary(12) == -1);
        Assert.assertTrue(coderService.showSalary(100) == 100);

        //基本类型，mock参数为实际值,实际参数 equals mock参数时，mock成功
        Assert.assertTrue("mocked".equals(
                coderService.getPersonName(new Person("me", 4, null))));
        Assert.assertFalse("mocked".equals(
                coderService.getPersonName(new Person("you", 3, null))));
    }

}