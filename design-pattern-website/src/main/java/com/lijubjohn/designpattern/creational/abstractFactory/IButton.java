package com.lijubjohn.designpattern.creational.abstractFactory;

/**
 * Created by liju on 8/22/16.
 */
public interface IButton {
    public void renderButton();
}

class WindowsButton implements IButton{
    @Override
    public void renderButton() {
        System.out.println("rendering windows button");
    }
}

class MacButton implements IButton{
    @Override
    public void renderButton() {
        System.out.println("rendering mac OSX button");
    }
}
