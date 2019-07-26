package com.njupt.javaDemo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapDemo {
    /**
     * Map的三种遍历方式*/
    public static void main(String[] args){
        Map<String,String> map = new HashMap<String,String >();
        map.put("111","张三");
        map.put("222","李四");
        map.put("333","王二");

        /**
         * 第一种*/
        for (String key:map.keySet()) {
            String value = map.get(key).toString();
            System.out.println(value);
        }

        /**
         * 第二种*/
        Iterator<Map.Entry<String,String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String ,String> entry = iterator.next();
            System.out.println(entry.getKey()+entry.getValue());
        }

        /**
         * 第三种*/
        for (Map.Entry<String,String> m:map.entrySet()) {
            System.out.println(m.getKey()+m.getValue());
        }
    }
}
