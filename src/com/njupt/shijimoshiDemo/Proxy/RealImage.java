package com.njupt.shijimoshiDemo.Proxy;

public class RealImage implements Image {

    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromDisk(fileName);
    }

    @Override
    public void display() {
        System.out.println("diaplaying"+fileName);
    }

    private void loadFromDisk(String fileName){
        System.out.println("loading"+fileName);
    }


}
