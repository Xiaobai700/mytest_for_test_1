package com.njupt.shijimoshidemo.flyweight;

import java.util.HashMap;

public class Factory {
    private static final HashMap<String,Shape> circleMap = new HashMap<>();

    public static Circle getCircle(String color){
        Circle circle = (Circle) circleMap.get(color);
        if(circle == null){
            circle = new Circle(color);
            circleMap.put(color,circle);
            System.out.println("创建了一个"+color+"颜色的圆");
        }
        return circle;
    }
}
