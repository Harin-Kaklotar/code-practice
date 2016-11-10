package generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by liju on 11/8/16.
 */
public class WildCardBoundExample {
}

interface Animal{
    void feed();
}
class Carnivorous implements Animal{
    @Override public void feed() {
        System.out.println("feeding");
    }
}
class Herbivorous implements Animal{
    @Override public void feed() {
        System.out.println("feeding");
    }
}
class Dog extends Carnivorous{}
class Cow extends Herbivorous{}

/**
 * Generic method example
 */
class GenericMethodExample {

    /**
     * Generic method example
     */
    public static  <T> List<T> toList(T[] array) {
        List<T> list = new ArrayList();
        for (T element : array) {
            list.add(element);
        }
        return list;
    }

    /**
     * Generic wildcard example
     */
    public static <T> void copy(List<? extends T> src , List<? super T> dest){
        for (int i = 0; i < src.size(); i++) {
            dest.set(i,src.get(i));
        }
    }

    public static void main(String[] args) {

        //call to Generic method example
        Integer[] ints = new Integer[]{1,2,3};
        final List<Integer> integerList = toList(ints);


        // call  to Generic wildcard example
        List<Object> objs = Arrays.asList(10, 13.14, "one");
        List<Integer> integers = Arrays.asList(15, 16);
        copy(integers,objs);


    }
}


