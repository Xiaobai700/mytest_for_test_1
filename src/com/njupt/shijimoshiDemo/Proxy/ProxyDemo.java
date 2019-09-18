package com.njupt.shijimoshiDemo.Proxy;

public class ProxyDemo {
    public static void main(String[] args){
        Image image = new ProxyImage("test.jpg");
        //图像将从磁盘加载
        image.display();
        //图像将不会从磁盘加载
        image.display();
    }
}
