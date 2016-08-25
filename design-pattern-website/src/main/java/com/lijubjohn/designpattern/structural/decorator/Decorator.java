package com.lijubjohn.designpattern.structural.decorator;

/**
 * Created by Liju on 8/24/2016.
 */
public class Decorator {
}

// This is the type of object which we need to decorate
interface Window {
    void draw();
}
//simple implementation of Window
class SimpleWindow implements Window {
    @Override
    public void draw() {
        System.out.println("draw simple window");
    }
}

//Abstract decorator for Window (note : it implements type of object which we need to decorate)
abstract class WindowDecorator implements Window {
    protected Window window;// object to be decorated

    protected WindowDecorator(Window window) {
        this.window = window;
    }

    @Override
    public void draw() {
        window.draw();//delegation
    }
}

// One implementation of window decorator
class HorizontalScrollBarDecorator extends WindowDecorator {

    public HorizontalScrollBarDecorator(Window window) {
        super(window);
    }

    @Override
    public void draw() {
        super.draw();
        //decoration
        System.out.println("add horizontal scroll bar to the window");
    }
}
// Another implementation of window decorator
class VerticalScrollBarDecorator extends WindowDecorator {

    public VerticalScrollBarDecorator(Window window) {
        super(window);
    }

    @Override
    public void draw() {
        super.draw();
        //decoration
        System.out.println("add vertical scroll bar to the window");
    }
}
//Client
class Client {
    public static void main(String[] args) {
        Window decoratedWindow = new VerticalScrollBarDecorator(new HorizontalScrollBarDecorator(new SimpleWindow()));
        decoratedWindow.draw();
    }
}