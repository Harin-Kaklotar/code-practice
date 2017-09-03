package sorting;

import java.util.*;

/**
 * Created by liju on 8/13/17.
 * https://www.hackerrank.com/challenges/lilys-homework
 *
 */

//TODO complete
public class LilysHomework {
    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<Integer, Integer> input = new HashMap<>();

        for (int i = 0; i < n; i++) {
            input.put(sc.nextInt(), i);
        }

        List<Integer> values  = new ArrayList<>(input.values());
        Collections.sort(values);
        Map<Integer, Integer> copy = new HashMap<>();
        for (int i = 0; i < values.size(); i++) {
            copy.put(values.get(i), i);
        }

        Collections.sort(values,Collections.reverseOrder());

        for (int i = 0; i < values.size(); i++) {
            copy.put(values.get(i), i);
        }

        int swapsAsc = countSwaps(input,copy);

        //System.out.println((swapsAsc < swapsDesc) ? swapsAsc : swapsDesc);

    }

    private static int countSwaps(Map<Integer, Integer> input, Map<Integer, Integer> copy) {
        for(Map.Entry<Integer,Integer> entry : input.entrySet()){
            if (entry.getValue()!=copy.get(entry.getKey())){
                Integer correctVal = copy.get(entry.getKey());
                input.put(entry.getKey(),correctVal);
            }
        }

    }*/


}


