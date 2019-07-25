package com.njupt.shijimoshiDemo.Decorator;

public abstract class ShapeDerator implements Shape {
    protected Shape shape;
    public ShapeDerator(Shape shape){
        this.shape = shape;
    }

    public void draw(){
        shape.draw();
    }
}
