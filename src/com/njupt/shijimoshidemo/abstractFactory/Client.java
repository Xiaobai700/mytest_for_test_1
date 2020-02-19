package com.njupt.shijimoshidemo.abstractFactory;

/*有一个工厂，可以生产两种型号的产品*/
interface  Product1{
    public void show();
}
interface Product2{
    public void show();
}
class ProductDemo1 implements Product1{

    @Override
    public void show() {
        System.out.println("这是第一种型号的产品");
    }
}
class ProductDemo2 implements Product2{

    @Override
    public void show() {
        System.out.println("这是第二种型号的产品");
    }
}

interface Factory{
    public Product1 shengchan1();
    public Product2 shengchan2();
}

class FactoryDemo implements Factory{

    @Override
    public Product1 shengchan1() {
        return new ProductDemo1();
    }

    @Override
    public Product2 shengchan2() {
        return new ProductDemo2();
    }
}

public class Client {
    public static void main(String[] args){
        Factory factory = new FactoryDemo();
        factory.shengchan1().show();
        factory.shengchan2().show();
    }
}
