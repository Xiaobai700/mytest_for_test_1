package com.njupt.shijimoshiDemo.singleton;

public class Singleton {
    /**
     * 单例模式的几种实现方式
     * */

    /**
     * 最基础的一种实现方式
     * 线程不安全的懒汉式*/
    private static Singleton instance;
    private Singleton(){}
    public static Singleton getInstance(){
        if(instance == null){
            instance = new Singleton();
        }
        return instance;
    }
    /**
     * 线程安全的懒汉式*/
    /*private static Singleton instance;
    private Singleton(){}
    public static synchronized Singleton getInstance(){
        if(instance == null){
            instance = new Singleton();
        }
        return instance;
    }*/

    /**
     * 饿汉式*/
    /*private static Singleton instance = new Singleton();
    private Singleton(){

    }
    public static Singleton getInstance(){
        return instance;
    }*/

    /**
     * 双检锁/双重校验锁*/
    /*private volatile static Singleton singleton;
    private Singleton (){}
    public static Singleton getSingleton() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
            return singleton;
        }*/

    /**
     * 登记式/静态内部类*/
    /*private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }
    private Singleton (){}
        public static final Singleton getInstance() {
            return SingletonHolder.INSTANCE;
        }*/

    /**
     * 枚举*/


}
