package com.njupt.shijimoshidemo.decorator;

public class RedShapeDerator extends ShapeDerator {
    public RedShapeDerator(Shape shape) {
        super(shape);
    }

    @Override
    public void draw() {
       shape.draw();
        setRedBorder(shape);
    }

    private void setRedBorder(Shape decoratedShape){
        System.out.println("我是红色的");
    }

}
