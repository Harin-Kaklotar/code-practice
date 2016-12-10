package array;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by liju on 12/9/16.
 */
public class SparseArray {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<String,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            String input = sc.next();
            if(map.containsKey(input)) {
                map.put(input,map.get(input)+1);
            }
            else
                map.put(input,1);
        }
        int q  = sc.nextInt();
        for(int i=0;i<q;i++){
            String input = sc.next();
            if(map.containsKey(input))
                System.out.println(map.get(input));
            else
                System.out.println(0);

        }
    }
}
