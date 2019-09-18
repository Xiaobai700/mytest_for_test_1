package com.njupt.shijimoshiDemo.Decorator;

public abstract class ShapeDerator implements Shape {
    protected Shape shape;
    public ShapeDerator(Shape shape){
        this.shape = shape;
    }

    @Override
    public void draw(){
        shape.draw();
    }
}
