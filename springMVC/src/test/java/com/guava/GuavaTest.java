//package com.guava;
//
//import com.google.common.base.Optional;
//import com.google.common.collect.Ordering;
//import com.guava.cache.GuavaCacheDemo;
//import com.guava.cache.GuavaCacheDemo2;
//import com.guava.model.Man;
//import com.sheng.example.springaop.SpringTestCase;
//import org.junit.Test;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
///**
// * @author huangy on 2018/7/22
// */
//public class GuavaTest {
//
//    private static final Logger LOGGER = LoggerFactory.getLogger(GuavaTest.class);
//
//    private static final GuavaCacheDemo cachDemo = new GuavaCacheDemo();
//
//    static {
//        cachDemo.InitLoadingCache();
//    }
//
//    @Test
//    public void testOption() {
//        Integer a = null;
//        Integer b = 10;
//
//        Optional<Integer> optionalA = Optional.of(a);
//        Optional<Integer> optionalB = Optional.of(b);
//
//        LOGGER.info("opetion , result={}", optionalA.get() + optionalB.get());
//    }
//
//    @Test
//    public void testOrdering () {
//        List<Integer> numbers = new ArrayList<>();
//        numbers.add(new Integer(5));
//        numbers.add(new Integer(2));
//        numbers.add(new Integer(15));
//        numbers.add(new Integer(51));
//        numbers.add(new Integer(53));
//        numbers.add(new Integer(35));
//        numbers.add(new Integer(45));
//        numbers.add(new Integer(32));
//        numbers.add(new Integer(43));
//        numbers.add(new Integer(16));
//
//        Ordering ordering = Ordering.natural();
//        System.out.println("Input List: ");
//        System.out.println(numbers);
//
//        Collections.sort(numbers,ordering );
//        System.out.println("Sorted List: ");
//        System.out.println(numbers);
//
//        System.out.println("======================");
//        System.out.println("List is sorted: " + ordering.isOrdered(numbers));
//        System.out.println("Minimum: " + ordering.min(numbers));
//        System.out.println("Maximum: " + ordering.max(numbers));
//
//        Collections.sort(numbers,ordering.reverse());
//        System.out.println("Reverse: " + numbers);
//
//        numbers.add(null);
//        System.out.println("Null added to Sorted List: ");
//        System.out.println(numbers);
//
//        List<String> names = new ArrayList<String>();
//        names.add("Ram");
//        names.add("Shyam");
//        names.add("Mohan");
//        names.add("Sohan");
//        names.add("Ramesh");
//        names.add("Suresh");
//        names.add("Naresh");
//        names.add("Mahesh");
//        names.add(null);
//        names.add("Vikas");
//        names.add("Deepak");
//
//        System.out.println("Another List: ");
//        System.out.println(names);
//
//        Collections.sort(names,ordering.nullsFirst().reverse());
//        System.out.println("Null first then reverse sorted list: ");
//        System.out.println(names);
//    }
//
//    @Test
//    public void testCache(){
//        System.out.println("使用loadingCache get方法  第一次加载");
//        Man man = cachDemo.getCacheKeyloadingCache("001");
//        System.out.println(man);
//
//        System.out.println("\n使用loadingCache getIfPresent方法  从缓存中加载刚刚加载过的数据 001");
//        man = cachDemo.getIfPresentloadingCache("001");
//        System.out.println(man);
//
//        System.out.println("\n使用loadingCache get方法  第一次加载，从数据库获得 002");
//        man = cachDemo.getCacheKeyloadingCache("002");
//        System.out.println(man);
//
//        System.out.println("\n使用loadingCache get方法  已加载过，从缓存中拿 002");
//        man = cachDemo.getCacheKeyloadingCache("002");
//        System.out.println(man);
//
//        System.out.println("\n使用loadingCache get方法  已加载过,但是已经被剔除掉,验证重新加载");
//        man = cachDemo.getCacheKeyloadingCache("001");
//        System.out.println(man);
//
//        System.out.println("\n使用loadingCache getIfPresent方法  已加载过");
//        man = cachDemo.getIfPresentloadingCache("001");
//        System.out.println(man);
//
//        System.out.println("\n使用loadingCache put方法  再次get");
//        Man newMan = new Man();
//        newMan.setId("001");
//        newMan.setName("额外添加");
//        cachDemo.putloadingCache("001",newMan);
//        man = cachDemo.getCacheKeyloadingCache("001");
//        System.out.println(man);
//    }
//
//    @Test
//    public void testCache2() throws Exception {
//        GuavaCacheDemo2 cachDemo = new GuavaCacheDemo2();
//        cachDemo.Init();
//
//        System.out.println("使用loadingCache");
//        cachDemo.InitLoadingCache();
//
//        System.out.println("使用loadingCache get方法  第一次加载 001");
//        Man man = cachDemo.getCacheKeyloadingCache("001");
//        System.out.println(man);
//
//        Thread.sleep(3000);
//
//        System.out.println("\n使用loadingCache getIfPresent方法  数据过期了");
//        man = cachDemo.getIfPresentloadingCache("001");
//        System.out.println(man);
//
////        System.out.println("\n使用loadingCache getIfPresent方法  第一次加载 002");
////        man = cachDemo.getIfPresentloadingCache("002");
////        System.out.println(man);
////
////        System.out.println("\n使用loadingCache get方法  第一次加载");
////        man = cachDemo.getCacheKeyloadingCache("002");
////        System.out.println(man);
////
////        System.out.println("\n使用loadingCache get方法  已加载过");
////        man = cachDemo.getCacheKeyloadingCache("002");
////        System.out.println(man);
////
////        System.out.println("\n使用loadingCache get方法  已加载过,但是已经被剔除掉,验证重新加载");
////        man = cachDemo.getCacheKeyloadingCache("001");
////        System.out.println(man);
////
////        System.out.println("\n使用loadingCache getIfPresent方法  已加载过");
////        man = cachDemo.getIfPresentloadingCache("001");
////        System.out.println(man);
////
////        System.out.println("\n使用loadingCache put方法  再次get");
////        Man newMan = new Man();
////        newMan.setId("001");
////        newMan.setName("额外添加");
////        cachDemo.putloadingCache("001",newMan);
////        man = cachDemo.getCacheKeyloadingCache("001");
////        System.out.println(man);
////
////        ///////////////////////////////////
////        System.out.println("\n\n使用Cache");
////        cachDemo.InitDefault();
////
////        System.out.println("使用Cache get方法  第一次加载");
////        man = cachDemo.getCacheKeyCache("001");
////        System.out.println(man);
////
////        System.out.println("\n使用Cache getIfPresent方法  第一次加载");
////        man = cachDemo.getIfPresentCache("002");
////        System.out.println(man);
////
////        System.out.println("\n使用Cache get方法  第一次加载");
////        man = cachDemo.getCacheKeyCache("002");
////        System.out.println(man);
////
////        System.out.println("\n使用Cache get方法  已加载过");
////        man = cachDemo.getCacheKeyCache("002");
////        System.out.println(man);
////
////        System.out.println("\n使用Cache get方法  已加载过,但是已经被剔除掉,验证重新加载");
////        man = cachDemo.getCacheKeyCache("001");
////        System.out.println(man);
////
////        System.out.println("\n使用Cache getIfPresent方法  已加载过");
////        man = cachDemo.getIfPresentCache("001");
////        System.out.println(man);
////
////        System.out.println("\n使用Cache put方法  再次get");
////        Man newMan1 = new Man();
////        newMan1.setId("001");
////        newMan1.setName("额外添加");
////        cachDemo.putloadingCache("001",newMan1);
////        man = cachDemo.getCacheKeyloadingCache("001");
////        System.out.println(man);
//    }
//}
