package com.sheng.example.springaop;

import org.junit.Test;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.Arrays;
import java.util.List;

/**
 * @author huangy
 * @date 2017/12/30
 */
public class TestArrays {

    @Test
    public void testArrays() {
        Integer role = null;
        List list = Arrays.asList(role);
        System.out.println(list);

//        Arrays.asList(null);
    }
}
