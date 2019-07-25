package com.njupt.shijimoshiDemo.Decorator;

public class DecoratoeDemo {
    public static void main(String[] args){
        Shape yuan = new yuan();
        ShapeDerator redyuan = new RedShapeDerator(new yuan());
        ShapeDerator redzhengfangxing = new RedShapeDerator(new zhengfangxing());

        yuan.draw();
        System.out.println("*************************************************");
        redyuan.draw();
        System.out.println("*************************************************");
        redzhengfangxing.draw();
    }
}
