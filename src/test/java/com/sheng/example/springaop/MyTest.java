package com.sheng.example.springaop;

import com.sheng.example.springaop.service.AOPService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dell on 2017/1/20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:ApplicationContext.xml")
public class MyTest {
    @Autowired
    private AOPService aopService;
    @Test
    public void testAOP(){
        System.out.println(aopService.aoptest());

    }

    @Test
    public void convert() {
        String tem =
                "qudaocsm2,gscnac,569542,fstestfengyao2015,570386,577382,lilygroup,shmskg,577339,577340,577152,nxlwgs,wwm0318,jxyaxun,yuanzhi,qingyun,tcyyxx,wfbstech,xmpxgs,jmzerol,ntyushun,masjcwl,shun1005,huofh98,yuanjianedu,fujianredre,dyhdxx,tchstchs,nbfxiaoke,gxnnrz,fenyixiang,whxyun,xzftxx,lygctwlkj,szdlwwl,ccbpkj,gxzgwlkj,428645,zpc591,282489,xydjwl,yunceng888,476619,467882,gsdlbkj,fjchenyi,480923,485532,185394,hjxxkj,521394,jiaxinthj,523942,524571,528224,531065,499153,523317,532747,winflykeji,qddhfkj,479875,531782,543743,546922,cdkrjsm,zzzhmy2016,cdxj888,njyucp";

        String[] arr = tem.split(",");

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            if (i != (arr.length - 1)) {
                sb.append(arr[i] + ";");
            } else {
                sb.append(arr[i]);
            }
        }

        System.out.println(sb.toString());
    }

    @Test
    public void TestJava8() {
        List<Integer> list = new ArrayList<>();
        list.add(null);

        System.out.println("result: " + list.contains("xxxada"));
    }
}
