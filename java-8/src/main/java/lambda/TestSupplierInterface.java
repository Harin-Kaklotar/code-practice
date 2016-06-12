package com.lijujohn.java8.lambda;

import java.util.function.Supplier;

/**
 * Created by liju on 5/4/16.
 */
public class TestSupplierInterface {

    public static void main(String[] args) {

        Supplier<Apples> applesSupplier = () -> new Apples();
        System.out.println(applesSupplier.get().name());
        Supplier<Oranges> orangesSupplier = Oranges::new;
        System.out.println(orangesSupplier.get().name());

    }

}
class Apples{
    public String name(){
        return "apple";
    }
}
class Oranges{
    public String name(){
        return "orange";
    }
}
