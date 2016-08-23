package com.lijubjohn.structural.adapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liju on 8/22/16.
 */
interface InterfaceA {
    public void print(String text);
}
class InterfaceAImpl implements InterfaceA{
    @Override public void print(String text) {
        System.out.println(text);
    }
}

interface InterfaceB{
    public void print(List<String> listTexts);
}

class InterfaceBImpl implements InterfaceB{
    @Override public void print(List<String> listTexts) {
        listTexts.stream().forEach(text -> System.out.println(text));
    }
}
//we have instance of type interfaceB but want to use interfaceA , make an adapter for interfaceA
public class Adapter implements InterfaceB {
    private InterfaceA interfaceA;
    public Adapter(InterfaceA interfaceA){
        this.interfaceA = interfaceA;
    }

    @Override
    public void print(List<String> listTexts) {
        listTexts.stream().forEach(text -> interfaceA.print(text));
    }
}

class Client{
    public static void main(String[] args) {
        List<String> testList = new ArrayList(){
            {
                add("abc");
                add("xyz");
            }
        };
        final Adapter adapter = new Adapter(new InterfaceAImpl());
        adapter.print(testList);
    }
}
