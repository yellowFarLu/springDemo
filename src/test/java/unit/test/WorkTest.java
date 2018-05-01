package unit.test;

import com.sheng.example.springaop.jmockit.OtherVO;
import com.sheng.example.springaop.jmockit.Work;
import mockit.*;
import mockit.integration.junit4.JMockit;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

@RunWith(JMockit.class)
public class WorkTest {
    @Tested
    @Mocked
    Work work;

    @Test
    public void testTask() throws Exception {
        final OtherVO otherVO = new OtherVO();
        new Expectations(OtherVO.class) { // mock OtherVO的行为
            {
                otherVO.getValue();
                result = "zero";
            }
        };
        new Expectations() {
            {
                // --- 通过以上方式可以将mock出来的otherVO设置到work中，当然可以采取其它简便方式
                Deencapsulation.setField(work, "otherVO", otherVO);
            }
        };


        work.task();

        Thread.sleep(1000);
    }
}