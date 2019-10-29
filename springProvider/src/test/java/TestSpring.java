
import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.huang.yuan.dubbo.adaptive.AdaptiveExt;
import common.IntegrationTestBase;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * @author huangy on 2018/9/29
 */
public class TestSpring extends IntegrationTestBase {

    @Test
    public void test1() {
        // 获取这个类的ExtensionLoader
        ExtensionLoader<AdaptiveExt> extExtensionLoader = ExtensionLoader.getExtensionLoader(AdaptiveExt.class);

        // 加载自适应代理
        AdaptiveExt adaptiveExt = extExtensionLoader.getAdaptiveExtension();

        // 方法调用的时候，根据url的参数选择加载实现类
//        URL url = URL.valueOf("test://localhost/test?adaptive.ext=spring");

        URL url = URL.valueOf("test://localhost/test");

        System.out.println(adaptiveExt.echo("d", url));
    }

}
