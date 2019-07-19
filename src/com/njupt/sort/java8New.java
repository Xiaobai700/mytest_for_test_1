package com.njupt.sort;

import java.util.HashMap;
import java.util.Map;

public class java8New {

    public static void main(String[] args){
        /**
         * 关于Map中getOrDefault()方法的Demo
         * Map集合中有这个key时，它的value就是他本身的value，
         * 如果Map集合中没有这个key，那么这个key对应的值就是通过这个函数设置的默认的值*/
        Map map = new HashMap();
        map.put("张三",20);
        map.put("李素",34);
        map.put("王二",99);
        Integer score1 = (Integer) map.getOrDefault("张三",1000);
        Integer score2 = (Integer) map.getOrDefault("张巧",88);
        System.out.println(score1);
        System.out.println(score2);


    }
}
