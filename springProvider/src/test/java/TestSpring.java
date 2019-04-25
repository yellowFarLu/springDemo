import com.huang.yuan.api.model.ModelResult;
import com.huang.yuan.api.service.DemoService;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * @author huangy on 2018/9/29
 */
public class TestSpring extends IntegrationTestBase {

    @Resource
    private DemoService demoService;

    @Test
    public void testdada() {
        ModelResult result = demoService.test("huangyuan");
        log(result);
    }
}
