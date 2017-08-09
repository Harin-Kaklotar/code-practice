package string;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by liju on 8/8/17.
 * https://www.hackerrank.com/challenges/bear-and-steady-gene
 * <p>
 * Hint  - Sliding window technique
 */
public class BearAndSteadyGenes {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[] chars = sc.next().toCharArray();
        Map<Character, Integer> charCountMap = new HashMap<>();
        //count map for each character
        for (int i = 0; i < chars.length; i++) {
            if (charCountMap.get(chars[i]) != null) {
                charCountMap.put(chars[i], charCountMap.get(chars[i]) + 1);
            } else {
                charCountMap.put(chars[i], 1);
            }
        }

        int left = 0, right = 0, min = Integer.MAX_VALUE;
        while(right < n - 1){
            char rc = chars[right++];
            charCountMap.put(rc, charCountMap.get(rc) - 1);
            while(steady(charCountMap,n)){
                min = Math.min(min, right - left);
                char lc = chars[left++];
                charCountMap.put(lc, charCountMap.get(lc) + 1);
            }
        }
        System.out.println(min);

    }

    private static boolean steady(Map<Character, Integer> charCountMap, int n) {
        return !charCountMap.values().stream().anyMatch(i -> i > n / 4);
    }
}
