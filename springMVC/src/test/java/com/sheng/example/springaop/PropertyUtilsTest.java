package com.sheng.example.springaop;

import com.sheng.example.springaop.model.arg.GroupDO;
import com.sheng.example.springaop.model.arg.GroupVO;
import org.apache.commons.beanutils.PropertyUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

/**
 * @author huangy
 * @date 2018/1/13
 */
public class PropertyUtilsTest {

    @Test
    public void testCopy() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        GroupVO groupVO = new GroupVO();
        groupVO.setName("huangy");
        groupVO.setAge(18);

        GroupDO groupDO = new GroupDO();

        PropertyUtils.copyProperties(groupDO, groupVO);

        System.out.println(groupDO);
    }

}
