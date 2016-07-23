package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by liju on 5/4/16.
 * The java.util.function.Predicate<T> interface defines an abstract method named test that accepts an object of generic type T
 * and returns a boolean. It’s exactly the same one that you created earlier, but is available out of the box! You might want to use this interface
 * when you need to represent a boolean expression that uses an object of type T
 */

public class TestPredicateInterface<T> {

    public static <T> List<T> filter(List<T> list ,Predicate<T> predicate){

        List<T> result  = new ArrayList<>();
        for (T t : list){
            if (predicate.test(t)){
                result.add(t);
            }
        }
        return result;
    }

    public static void main(String[] args) {

        List<String>  stringList = new ArrayList<>();
        stringList.add("aaa");
        stringList.add("bbb");
        stringList.add("");
        stringList.add("ccc");
        // read as  : interface predicate takes input () -> and test ()
        Predicate<String> nonEmptyString = (String s) -> !s.isEmpty();
        System.out.println(filter(stringList,nonEmptyString));

        //Direct method reference
        System.out.println(filter(stringList,String::isEmpty));
    }
}
