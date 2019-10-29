package unit.test;

import com.factorybean.StudentFactoryBean;
import com.model.Student;
import com.sheng.example.springaop.SpringTestCase;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * @author huangy on 2019-10-27
 */
public class StudentFactoryBeanTest extends SpringTestCase {

    /**
     * 注意这里使用Student，也就是创建出来的Bean类型
     */
    @Resource
    Student studentFactoryBean;

    @Test
    public void func() {
        System.out.println(studentFactoryBean);
    }

}
