import com.huang.yuan.dubbo.component.JsonKit;
import com.huang.yuan.dubbo.model.Bean1;
import com.huang.yuan.dubbo.model.Bean2;

/**
 * @author huangy on 2018/11/9
 */
public class GsonTest {

    public static void main(String[] args) {
        Bean1 bean1 = new Bean1();
        bean1.setOne(1);
        bean1.setTwo(2);

        String json = JsonKit.object2json(bean1);

        Bean2 bean2 = JsonKit.json2object(json, Bean2.class);

        System.out.println(bean2);
    }

}
