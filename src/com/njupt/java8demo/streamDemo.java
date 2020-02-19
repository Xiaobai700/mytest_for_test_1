package com.njupt.java8demo;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @author zhangqiao
 * @date 2019/9/18 9:09
 */
public class streamDemo {
    public static void main(String[] args){
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        System.out.println("使用 Java 8: ");
        System.out.println("列表: " +strings);

        /**
         * filter 方法用于通过设置的条件过滤出元素
         * */
        long count = strings.stream().filter(string->string.isEmpty()).count();
        System.out.println("空字符串数量为: " + count);

        count = strings.stream().filter(string -> string.length() == 3).count();
        System.out.println("字符串长度为 3 的数量为: " + count);

        List<String> filtered = strings.stream().filter(string ->!string.isEmpty()).collect(Collectors.toList());
        System.out.println("筛选后的列表: " + filtered);

        String mergedString = strings.stream().filter(string ->!string.isEmpty()).collect(Collectors.joining(", "));
        System.out.println("合并字符串: " + mergedString);

        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        /**
         * map 方法用于映射每个元素到对应的结果
         * */
        List<Integer> squaresList = numbers.stream().map( i ->i*i).distinct().collect(Collectors.toList());
        System.out.println("Squares List: " + squaresList);

        List<Integer> integers = Arrays.asList(1,2,13,4,15,6,17,8,19);
        System.out.println("列表: " +integers);

        IntSummaryStatistics stats = integers.stream().mapToInt((x) ->x).summaryStatistics();

        System.out.println("列表中最大的数 : " + stats.getMax());
        System.out.println("列表中最小的数 : " + stats.getMin());
        System.out.println("所有数之和 : " + stats.getSum());
        System.out.println("平均数 : " + stats.getAverage());
        System.out.println("随机数: ");
        // 输出10个随机数
        Random random = new Random();

        for(int i=0; i < 10; i++){
            System.out.println(random.nextInt());
        }
        /**
         * limit 方法用于获取指定数量的流
         * sorted 方法用于对流进行排序
         * */
        random.ints().limit(10).sorted().forEach(System.out::println);

        // 并行处理
        count = strings.parallelStream().filter(string -> string.isEmpty()).count();
        System.out.println("空字符串的数量为: " + count);
    }
}
