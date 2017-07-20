package string;

import javax.swing.text.html.parser.Entity;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by liju on 7/20/17.
 *
 * https://www.hackerrank.com/challenges/making-anagrams
 */
public class MakingAnagrams {

    static int makingAnagrams(String s1, String s2){
        // Complete this function
        Map<Character, Integer> mapS1 = new HashMap<>();
        Map<Character, Integer> mapS2 = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {

            if (mapS1.get(s1.charAt(i))!=null) {
                mapS1.put(s1.charAt(i),mapS1.get(s1.charAt(i))+1);
            }else{
                mapS1.put(s1.charAt(i), 1);
            }

        }

        for (int i = 0; i < s2.length(); i++) {

            if (mapS2.get(s2.charAt(i))!=null) {
                mapS2.put(s2.charAt(i),mapS2.get(s2.charAt(i))+1);
            }else{
                mapS2.put(s2.charAt(i), 1);
            }

        }
        int count =0 ;
        for(Map.Entry<Character,Integer> entry :mapS1.entrySet()){

            if (mapS2.containsKey(entry.getKey())){
                count += Math.abs(mapS2.get(entry.getKey()) - entry.getValue());
                mapS2.remove(entry.getKey());
            }else{
                count += entry.getValue();
            }
        }

        if (mapS2.size()>0)
            count+=mapS2.values().stream().mapToInt(i -> i).sum();

        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.next();
        String s2 = in.next();
        int result = makingAnagrams(s1, s2);
        System.out.println(result);
    }
}


