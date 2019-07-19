package com.njupt.sort;

import java.util.Comparator;

public class MyComparetor implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        int len1 = o1.getName().length();
        int len2 = o2.getName().length();
        int num = len1-len2;
        int num2 = num == 0 ? o1.getName().compareTo(o2.getName()):num;
        int num3 = num2 == 0 ? o1.getAge().compareTo(o2.getAge()):num2;

        return num3;
    }
}
