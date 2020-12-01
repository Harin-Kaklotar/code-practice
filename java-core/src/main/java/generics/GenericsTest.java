package generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Supplier;

public class GenericsTest {

    public static void main(String[] args) {

        String[] strArray = { "Red", "green", "Blue", "Yellow", "violet", "magenta", "pURPLE" };
    }

    private <T> void compareValues(Supplier<T> supplier, T value) {
        System.out.println(supplier.get() == value);
    }
}
class S{
    public static int getInt() {
        return 1;
    }
}


class MyListGeneric<Object> {
    private List<Object> values=new ArrayList<>();

    public void add(Object value) {
        values.add(value);    //line 1
        System.out.println(values);
    }

    public static void main(String[] args) {
        MyListGeneric<String> myListString = new MyListGeneric<String>();
        myListString.add("Good");
    }
}

class MyListGeneric1 {
    public static void displayElements(List<? super Integer> li) {
        System.out.println(li);     //line 4
    }
    public static void main(String[] args) {
        List<Number> i1=new ArrayList<Number>();
        i1.add(1009.9f);            //line 1
        i1.add(200);                //line 2
        i1.add(new Double(300));    //line 3
        displayElements(i1);
    }
}
