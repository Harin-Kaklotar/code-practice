package generics;

import java.util.Arrays;
import java.util.Comparator;
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

