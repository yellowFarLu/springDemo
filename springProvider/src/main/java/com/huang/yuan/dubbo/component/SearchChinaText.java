package com.huang.yuan.dubbo.component;

import com.google.common.io.Files;
import java.io.File;
import java.nio.charset.Charset;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchChinaText {
    private static Pattern linePattern = Pattern.compile("\"(.+)\"");
    private static Pattern chinesePattern = Pattern.compile("\"[\\u4E00-\\u9FBF]+");

    public static void main(String[] args) throws Exception {
        File dir = new File("/Users/huangyuan/Documents/fxiaoke/fs-wechat-union");
        findChinese(dir);
    }

    private static void findChinese(File file) throws Exception {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File f : files) {
                findChinese(f);
            }
        } else if (file.getPath().contains("main") && file.getName().endsWith(".java")) {
            List<String> lines = Files.readLines(file, Charset.forName("utf-8"));
            for (String line : lines) {
                if (hasChinese(line)) {
                    Matcher matcher = linePattern.matcher(line);
                    while (matcher.find()) {
                        System.out.println(file.getName() + " :  " + matcher.group(1));
                    }
                }
            }
        }
    }

    public static boolean hasChinese(String str) {
        if (str == null) {
            return false;
        }
        return chinesePattern.matcher(str).find();
    }
}