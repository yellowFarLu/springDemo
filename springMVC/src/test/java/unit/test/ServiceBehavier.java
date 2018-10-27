package unit.test;

import com.sheng.example.springaop.dao.DAO;
import com.sheng.example.springaop.service.Service;
import mockit.*;
import mockit.integration.junit4.JMockit;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author huangy
 * @date 2018/1/13
 */
@RunWith(JMockit.class)
public class ServiceBehavier {

    @Mocked
    DAO dao = new DAO();

    private Service service = new Service();

    @Test
    public void test() throws Exception {

        new MockUp<ThreadPoolExecutor>() {
            @Mock
            public void execute(Runnable command) {
                command.run();
            }
        };

        // 1. record 录制期望值
        new Expectations() {
            {
                dao.getStoreCount(anyString);// mock这个方法，无论传入任何String类型的值，都返回同样的值，达到黑盒的效果
                /**
                 * 预期结果，返回900
                 */
                result = 900;
                /**
                 times能且只能调用1次。
                 */
                times = 1;
            }
        };
        service.setDao(dao);

        // 2. replay 调用

        //3.校验是否只调用了一次。如果上面注释的语句再调一次，且把录制的times改为2，那么在验证阶段将会报错。
        new Verifications() {
            {
                dao.getStoreCount(anyString);
                times = 1;
            }
        };

    }
}