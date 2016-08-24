package com.lijubjohn.designpattern.structural.decorator;

/**
 * Created by Liju on 8/24/2016.
 */
public class Decorator {
}

interface Window {
    void draw();
}

class SimpleWindow implements Window {
    @Override
    public void draw() {
        System.out.println("draw simple window");
    }
}

abstract class WindowDecorator implements Window {
    protected Window window;

    protected WindowDecorator(Window window) {
        this.window = window;
    }

    @Override
    public void draw() {
        window.draw();
    }
}

class HorizontalScrollBarDecorator extends WindowDecorator {

    public HorizontalScrollBarDecorator(Window window) {
        super(window);
    }

    @Override
    public void draw() {
        super.draw();
        System.out.println("add horizontal scroll bar to the window");
    }
}

class VerticalScrollBarDecorator extends WindowDecorator {

    public VerticalScrollBarDecorator(Window window) {
        super(window);
    }

    @Override
    public void draw() {
        super.draw();
        System.out.println("add vertical scroll bar to the window");
    }
}

class Client {
    public static void main(String[] args) {
        Window decoratedWindow = new VerticalScrollBarDecorator(new HorizontalScrollBarDecorator(new SimpleWindow()));
        decoratedWindow.draw();
    }
}