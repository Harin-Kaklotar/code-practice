package simple;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by liju on 7/15/17.
 * https://www.hackerrank.com/challenges/the-time-in-words
 */
public class TimeInWords {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int hr = sc.nextInt();
        int min = sc.nextInt();

        Map<Integer, String> dict = new HashMap<>();
        dict.put(1,"one");
        dict.put(2,"two");
        dict.put(3,"three");
        dict.put(4,"four");
        dict.put(5,"five");
        dict.put(6,"six");
        dict.put(7,"seven");
        dict.put(8,"eight");
        dict.put(9,"nine");
        dict.put(10,"ten");
        dict.put(11,"eleven");
        dict.put(12,"twelve");
        dict.put(13,"thirteen");
        dict.put(14,"fourteen");
        dict.put(15,"fifteen");
        dict.put(16,"sixteen");
        dict.put(17,"seventeen");
        dict.put(18,"eighteen");
        dict.put(19,"nineteen");

        String timeInWord = "";
        if (min == 0 ) timeInWord = dict.get(hr) + " o' clock";
        else if (min == 1) timeInWord = dict.get(min) + " minute past "+ dict.get(hr);
        else if (min > 1 && min < 15) timeInWord = dict.get(min) + " minutes past "+ dict.get(hr);
        else if (min == 15) timeInWord = "quarter past "+dict.get(hr) ;
        else if (min > 15 && min < 30)  timeInWord = (min>20? "twenty "+ dict.get(min%20):dict.get(min) )+ " minutes past " + dict.get(hr);
        else if (min == 30) timeInWord = "half past "+dict.get(hr);
        else  if( min > 30 && min <45) timeInWord = (min < 40 ? "twenty " +dict.get((60-min)%20 ) :dict.get(60-min)) +" minutes to " + dict.get(hr+1) ;
        else if (min ==45) timeInWord = "quarter to " +dict.get(hr+1);
        else timeInWord = dict.get(15- min%15) + " minutes to "+ dict.get(hr+1);

        System.out.println(timeInWord);

    }
}
