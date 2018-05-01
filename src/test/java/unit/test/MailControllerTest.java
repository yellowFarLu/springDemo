package unit.test;

import com.sheng.example.springaop.jmockit.MailController;
import com.sheng.example.springaop.model.Result;
import com.sheng.example.springaop.service.MailService;
import mockit.Expectations;
import mockit.Injectable;
import mockit.Tested;
import mockit.integration.junit4.JMockit;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JMockit.class)
public class MailControllerTest {
    @Tested
    MailController mailController;
    @Injectable
    private MailService mailService;

    /**
     * mock掉mailService对象，只检测mailController的代码逻辑
     * @throws Exception
     */
    @Test
    public void should_return_status_success_when_send_mail_success() throws Exception {
        new Expectations() { {
            mailService.send("test@test.com", "test", "test");  // 模拟send方法
            result = new Result("傻逼");  // 模拟send方法的返回值
        } };
        String result = mailController.send("test@test.com", "test", "test");
        assertThat(result, is("成功"));
    }
}
