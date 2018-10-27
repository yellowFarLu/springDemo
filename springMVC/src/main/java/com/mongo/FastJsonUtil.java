package com.mongo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONPath;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class FastJsonUtil {
    public static String ObjectToString(Object o) {
        String s = JSON.toJSONString(o);
        return TrimDoubleQuote(s);
    }

    private static String TrimDoubleQuote(String s) {
        if (s.startsWith("\"") && s.endsWith("\"")) {
            s = s.substring(1, s.length());
            s = s.substring(0, s.length() - 1);
        }
        return s;
    }
}
