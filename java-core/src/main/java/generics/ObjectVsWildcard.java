package generics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liju on 3/25/18.
 */
public class ObjectVsWildcard {

    public void takeList(List<Object> list){

    }
    public void takeList1(List<?> list){

    }

    public static void main(String[] args) {
        ObjectVsWildcard ow = new ObjectVsWildcard();

        List<String> l1 = new ArrayList<String>();
        //ow.takeList(l1);  compiler error
        ow.takeList1(l1);

        // wont'compile generic array creation error
        //List<Integer> arrayOfIntegerList[] = new ArrayList<Integer>[10];

        List<Integer> integerList = new ArrayList<>();
        List<Number> numberList = new ArrayList<>();
        //wont' compile  -> incompatible types
        //numberList = integerList;



    }
}
