package com.lijubjohn.designpattern.creational.singleton;

/**
 * Created by Liju on 8/21/2016.
 */
//final to avoid extension
public final class Singleton {
    //private to avoid instantiation of this class from outside
    private Singleton(){}

    //inner static class for lazy loading the Singleton instance , the instance is created only on first access of SingletonHolder.instance
    private static final class SingletonHolder{
        private static final Singleton instance = new Singleton();
    }
    //method to singleton instance
    public Singleton getInstance(){
        return SingletonHolder.instance;
    }
}
