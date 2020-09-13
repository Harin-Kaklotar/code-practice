package collections;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liju on 8/12/20.
 */
public class MapExamples {

    public static void main(String[] args) {

        // Note :  hashcode for null key is 0
        Map<String, String> map = new HashMap();
        String a = "abc";
        String b = null;
        String c = null;
        map.put(a, "a");
        map.put(b, "b");
        map.put(c, "c");

        map.entrySet().stream().forEach(s -> System.out.println("key=" + s.getKey() + ", value=" + s.getValue()));
    }
}
