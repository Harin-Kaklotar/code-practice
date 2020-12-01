package generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GenericsBasics {
    public static void main(String[] args) {
        List<Number> nums = new ArrayList<>();
        nums.add(1);
        nums.add(1.2f);
        System.out.println(nums);

        List<Integer> ints = new ArrayList<Integer>();
        ints.add(1);
        ints.add(2);

         // List<Number> numbers = ints; // compile error .. why because if allowed you could add numbers in the int

        List<Number> nums1 = new ArrayList<Number>();
        nums.add(2.78);
        nums.add(3.14);
        // List<Integer> ints1 = nums; // compile-time error

        // List<Integer> is not a subtype of List<Number>, nor is List<Number> a subtype of List<Integer>
        // List<Integer> is a subtype of Collection<Integer>.

        /**
         Substitution Principle: a variable of a given type may be assigned a value of any subtype of that type,
         and a method with a parameter of a given type may be invoked with an argument of any subtype of that type.
         */

        Collection<Integer> col1 = new ArrayList<Integer>();


        // wildcards
        List<Integer> ints2 = new ArrayList<Integer>();
        ints2.add(1);
        ints2.add(2);
        List<? extends Number> nums2 = ints2;
        // nums2.add(3.14); // compile-time error .. as ints list can get manipulated





    }

     public static <T> void reverse(List<T> list) {
        List<T> tmp = new ArrayList<T>(list);
        for (int i = 0; i < list.size(); i++) {
            list.set(i, tmp.get(list.size()-i-1));
        }
    }
    //wildcard capture
    public static <T> void reverse2(List<?> list) {
        List<?> tmp = new ArrayList<Object>(list);
        for (int i = 0; i < list.size(); i++) {
      //      list.set(i, tmp.get(list.size()-i-1)); // error
        }
    }
}
