package unit.test;

import com.sheng.example.springaop.dao.DAO;
import com.sheng.example.springaop.jmockit.Guess;
import com.sheng.example.springaop.model.CustomerDO;
import com.sun.tools.classfile.Exceptions_attribute;
import mockit.Expectations;
import mockit.Injectable;
import mockit.Mocked;
import mockit.Tested;
import org.junit.Test;

/**
 * @author huangy
 * @date 2018/4/15
 */
public class TestJmockit {

    @Tested
    CustomerDO customerDO = new CustomerDO();

    @Injectable
    DAO dao;

    @Test
    public void testJokc() {
        new Expectations() {
            @Mocked()  // 表明被修饰的类对tryIt()方法进行mock。
            Guess g;
        };
    }
}
