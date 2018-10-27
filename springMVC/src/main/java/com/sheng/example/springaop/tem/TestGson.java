package com.sheng.example.springaop.tem;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author huangy on 2018/6/7
 */
public class TestGson {

    private static final Gson gson = new Gson();

    public static Gson getGson() {
        return gson;
    }

    public static void main(String[] args) {
        List<Map<String, Object>> filtersList = new ArrayList<>();
        Map<String, Object> map1 = new HashMap<>();
        map1.put("field_name1", "fieldName1");
        map1.put("field_values1", "fieldValues1");
        map1.put("operator1", "operator1");
        Map<String, Object> map2 = new HashMap<>();
        map2.put("field_name2", "fieldName2");
        map2.put("field_values2", "fieldValues2");
        map2.put("operator2", "operator2");
        filtersList.add(map1);
        filtersList.add(map2);

        String filtersStr = TestGson.getGson().toJson(filtersList);
        System.out.println("json = " + filtersStr);

        List<Map<String, Object>> filters =
                TestGson.getGson().fromJson(filtersStr, new TypeToken<List<Map<String, Object>>>() {}.getType());

        int i = 0;
        for (Map<String, Object> map : filters) {
            ++i;
            System.out.print(map.get("field_name" + i) + "  ");
            System.out.print(map.get("field_values" + i) + "  ");
            System.out.print(map.get("operator" + i) + "  ");

            System.out.println();
        }
    }

}
