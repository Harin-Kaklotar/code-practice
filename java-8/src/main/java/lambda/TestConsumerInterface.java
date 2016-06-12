package com.lijujohn.java8.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by liju on 5/4/16.
 *
 * The java.util.function.Consumer<T> interface defines an abstract method named accept that takes an object of generic type T and returns no result (void).
 * You might use this interface when you need to access an object of type T and perform some operations on it
 */
public class TestConsumerInterface<T> {

    public static <T> void printList(List<T> list , Consumer<T> consumer){
        for(T t: list){
            consumer.accept(t);
        }
    }

    public static void main(String[] args) {
        List<String>  stringList = new ArrayList<>();
        stringList.add("aaa");
        stringList.add("bbb");
        stringList.add("");
        stringList.add("ccc");
        // read as  : take input () -> and do this ()
        Consumer<String> consumer = (String s)-> System.out.println(s);
        printList(stringList,consumer);
    }
}
