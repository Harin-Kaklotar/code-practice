package com.lijujohn.java8.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Created by liju on 5/4/16.
 * The java.util.function.Function<T, R> interface defines an abstract method named
 * apply that takes an object of generic type T as input and returns an object of generic type R.
 * You might use this interface when you need to define a lambda that maps information from an
 * input object to an output (for example, extracting the weight of an apple or mapping a string to its length)
 */
public class TestFunctionInterface<T,R> {

    public static <T,R> List<R> getLength (List<T> list,Function<T,R> function){
        List<R> result  = new ArrayList<>();
        for (T t: list){
            result.add(function.apply(t));
        }
        return result;
    }

    public static void main(String[] args) {
        List<String>  stringList = new ArrayList<>();
        stringList.add("aaa");
        stringList.add("bbbb");
        stringList.add("");
        stringList.add("cc");

        Function<String,Integer> function = (String s) -> s.length();

        System.out.println(getLength(stringList,function));
    }
}
