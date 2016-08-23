package com.lijubjohn.designpattern.creational.singleton;

/**
 * Created by Liju on 8/21/2016.
 */
public enum SingletonUsingEnum {
    INSTANCE;

    public void doStuff() {
        System.out.println("I am using singleton instance");
    }

    public static void main(String[] args) {
        SingletonUsingEnum.INSTANCE.doStuff();
    }
}
