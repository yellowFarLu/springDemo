//package com.sheng.example.springaop.tem;
//
//import com.huangy.ioc.set.SpringActionImpl;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.context.support.FileSystemXmlApplicationContext;
//
///**
// * @author huangy on 2018/4/21
// */
//public class TestLoadSpring {
//
//    public static void main1(String[] args) {
//        ApplicationContext applicationContext =
//                new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
//        SpringActionImpl springActionImpl = applicationContext.getBean(SpringActionImpl.class);
//
//        System.out.println(springActionImpl);
//    }
//
//    public static void main(String[] args) {
//        ApplicationContext applicationContext =
//                new FileSystemXmlApplicationContext("classpath:applicationContext.xml");
//        SpringActionImpl springActionImpl = applicationContext.getBean(SpringActionImpl.class);
//
//        System.out.println(springActionImpl);
//    }
//
//
//}
