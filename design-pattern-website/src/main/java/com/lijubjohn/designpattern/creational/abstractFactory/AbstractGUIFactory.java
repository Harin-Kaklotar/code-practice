package com.lijubjohn.designpattern.creational.abstractFactory;

/**
 * Created by liju on 8/22/16.
 */
public abstract class AbstractGUIFactory {
    //contains methods for creating objects required for GUI design
    public abstract IButton createButton();
}

class WindowsGUIFactory extends AbstractGUIFactory {
    @Override
    public IButton createButton() {
        return new WindowsButton();
    }
}

class MacGUIFactory extends AbstractGUIFactory {
    @Override
    public IButton createButton() {
        return new MacButton();
    }
}

class Client {
    public static void main(String[] args) {
        //based on selection criteria get the required factory
        new MacGUIFactory().createButton();
        new WindowsGUIFactory().createButton();
    }
}