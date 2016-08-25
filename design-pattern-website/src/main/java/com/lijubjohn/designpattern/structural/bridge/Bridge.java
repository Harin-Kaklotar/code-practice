package com.lijubjohn.designpattern.structural.bridge;

//provides abstraction for how to draw circle
interface DrawingAPI {
    public void drawCircle(double x, double y, double radius);
}
//one implementation for drawing circle
class DrawingAPIA implements DrawingAPI {
    @Override
    public void drawCircle(double x, double y, double radius) {
        System.out.printf("Drawing coloured circle at (%f,%f) of radius %f", x, y, radius);
    }
}
//another implementation for drawing circle
class DrawingAPIB implements DrawingAPI {
    @Override
    public void drawCircle(double x, double y, double radius) {
        System.out.printf("Drawing black & white circle at (%f,%f) of radius %f", x, y, radius);
    }
}
/* provides abstraction for shape because the shape itself can vary (circle,square etc) and encapsulates drawingAPI
   as how to draw a circle may also vary (colored , black & white etc) */
abstract class Shape {
    protected DrawingAPI drawingAPI;

    protected Shape(DrawingAPI drawingAPI) {
        this.drawingAPI = drawingAPI;
    }

    public abstract void draw();

    public abstract void resizeRadiusByPct(double percentage);
}
//one implementation of shape
class CircleShape extends Shape {
    private double x, y, radius;

    public CircleShape(double x, double y, double radius, DrawingAPI drawingAPI) {
        super(drawingAPI);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    @Override
    public void draw() {
        drawingAPI.drawCircle(x, y, radius);
    }

    @Override
    public void resizeRadiusByPct(double percentage) {
        this.radius *= (1 + percentage / 100);
    }
}

public class Bridge {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[]{new CircleShape(1,2,10,new DrawingAPIA()),new CircleShape(1,2,10,new DrawingAPIB())};
        for (Shape shape :shapes){
            shape.resizeRadiusByPct(50);
            shape.draw();
        }
    }
}
