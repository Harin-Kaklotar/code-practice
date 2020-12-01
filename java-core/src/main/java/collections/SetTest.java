package collections;

import java.util.*;

public class SetTest {

    public static void main(String[] args) {
       /* Set<String> set=new TreeSet<>();
        set.add("Infosys");
        set.add("Google");
        set.add("IBM");
        for(String s:set){
            System.out.print(" "+s);
            set.clear();
        }*/

        List<String> al = new ArrayList<>();
        al.add("infosys");
        al.add("google");
        al.add("ibm");
        al.add("Amazon");
        for (int j = 0; j < al.size(); j++) {
            al.remove(j);
            System.out.println(al);
            System.out.println(al.get(++j));
            System.out.println(al.size());
            break;
        }

        Map<Integer, String> map = new TreeMap<>();
        map.put(1,null);
        System.out.println(map);

    }
}
