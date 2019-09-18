package com.njupt.java8Demo;

/**
 * @author zhangqiao
 * @date 2019/9/18 14:21
 */
public class lambdaDemo {
    public static void main(String[] args){
        MathOperation mathOperation = (a,b)->a+b;
        MathOperation mathOperation1 = (int a,int b)->{return a*b;};
        System.out.println(mathOperation.operation(8,0));
        System.out.println(mathOperation1.operation(8,0));
    }
    interface MathOperation{
        int operation(int a,int b);
    }
}
