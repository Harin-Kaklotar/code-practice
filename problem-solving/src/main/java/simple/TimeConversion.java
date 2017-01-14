package simple;

import java.util.Scanner;

/**
 * Created by liju on 1/13/17.
 *
 https://www.hackerrank.com/challenges/time-conversion

 */
public class TimeConversion {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final String input = sc.next();
        final String[] splits = input.split(":");
        int hh=Integer.valueOf(splits[0]);
        String mm=splits[1];
        String ss=splits[2].substring(0, 2);
        final String ampm = splits[2].substring(2, 4);

        if (ampm.equalsIgnoreCase("AM") && hh==12){
            hh = 0;
        }
        if (ampm.equalsIgnoreCase("PM")&& hh!=12){
            hh = (hh + 12) % 24;
        }

        String hhStr;
        if (hh<10){
             hhStr="0"+hh;
        }else {
            hhStr=String.valueOf(hh);
        }
        System.out.println(hhStr+":"+mm+":"+ss);
    }
}
