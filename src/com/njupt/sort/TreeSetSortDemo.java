package com.njupt.sort;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetSortDemo {
    public static void main(String[] args){
        /*自然排序*/
        Set<Student> set = new TreeSet<Student>();
        set.add(new Student("张三",21));
        set.add(new Student("张三",26));
        set.add(new Student("王二",24));
        set.add(new Student("麦子",25));
        for (Object o:set) {
            System.out.println(o);
        }

        System.out.println("*****************************************************");

        /*构造器排序*/
        TreeSet<Student> treeSet = new TreeSet<Student>(new MyComparetor());
        Student student = new Student("zhang1",58);
        Student student1 = new Student("zhang21",23);
        Student student2 = new Student("zhang1",56);
        Student student3 = new Student("zhang334",45);
        Student student4 = new Student("zhang45555",55);
        Student student5 = new Student("zhang5555555",67);
        treeSet.add(student);
        treeSet.add(student1);
        treeSet.add(student2);
        treeSet.add(student3);
        treeSet.add(student4);
        treeSet.add(student5);
        for (Object o:treeSet) {
            System.out.println(o);
        }



    }
}
