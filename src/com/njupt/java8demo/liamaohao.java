package com.njupt.java8demo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangqiao
 * @date 2019/9/18 15:12
 */
public class liamaohao {
    public static void main(String[] args){
        List names = new ArrayList();

        names.add("Google");
        names.add("Runoob");
        names.add("Taobao");
        names.add("Baidu");
        names.add("Sina");

        names.forEach((name)->System.out.println("hi"+name));
    }
}
