//package com.redis;
//
//import com.sheng.example.springaop.SpringTestCase;
//import org.junit.Test;
//
//import javax.annotation.Resource;
//
//import static org.junit.Assert.*;
//
///**
// * @author huangy on 2018/8/26
// */
//public class QueueDemoTest extends SpringTestCase {
//
//    @Resource
//    private QueueDemo queueDemo;
//
//    @Test
//    public void testQueue() {
//        for (int i = 0; i < 10; i++) {
//            queueDemo.delay("msg=" + i);
//        }
//
//        queueDemo.loop();
//    }
//}