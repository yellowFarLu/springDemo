package unit.test;

import com.sheng.example.springaop.jmockit.CustomerDAO;
import com.sheng.example.springaop.jmockit.CustomerDAOImpl;
import com.sheng.example.springaop.jmockit.CustomerManager;
import com.sheng.example.springaop.jmockit.CustomerManagerImpl;
import mockit.Mock;
import mockit.MockUp;
import mockit.Mocked;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * @author huangy
 * @date 2018/1/13
 */
public class CustomerManagerTest {

    @Resource
    private CustomerManager customerManager = new CustomerManagerImpl();

    @Mocked
    private CustomerDAO customerDAO;

    @Test
    public void testSave() {

        new MockUp<CustomerDAOImpl>() {
            @Mock
            public int save(String name) {
                System.out.println("CustomerManagerTest: dao save");
                return 1;
            }
        };

        customerManager.setCustomerDAO(customerDAO);

        customerManager.save("哈哈");
    }

}
