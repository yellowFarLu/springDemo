import com.alibaba.fastjson.JSON;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author huangy on 2018/9/29
 */
@Ignore
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/spring/applicationContext.xml")
public class IntegrationTestBase extends AbstractJUnit4SpringContextTests {

    {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY,
                "/Users/huangyuan/Desktop/Study/code/springAOP/springProvider/src/test/java");

    }

    public void log(Object result) {
        logger.debug("--------------------start----------------------------------");
        logger.debug("result:" + result);
        logger.debug("--------------------end------------------------------------");
    }
}
