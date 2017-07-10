package simple;

import java.util.Scanner;

/**
 * Created by liju on 7/9/17.
 * https://www.hackerrank.com/challenges/day-of-the-programmer
 */
public class DayOfProgrammer {

    enum YR_TYPE{
        JULIAN,GREGORIAN,OTHER

    }

    static String solve(int year){
        // Complete this function
        if(isJulianYear(year)){
            if (isLeapYr(year,YR_TYPE.JULIAN)) return "12.09."+year;
            else return  "13.09."+year;
        }else if(isGregorianYear(year)){
            if(isLeapYr(year,YR_TYPE.GREGORIAN)) return  "12.09."+year;
            else return  "13.09."+year;
        }else if(year == 1918){
            return "26.09.1918";
        }else{
            throw new IllegalArgumentException("invalid year as input");
        }
    }

    static boolean isJulianYear(int yr){
        return yr >=1700 && yr <= 1917;
    }

    static boolean isGregorianYear(int yr){
        return yr >=1919 && yr <=2700;
    }

    static boolean isLeapYr(int yr , YR_TYPE yrtype){
        switch (yrtype){
            case JULIAN: return yr %4 ==0;
            case GREGORIAN: return (yr%400==0) || (yr%4==0 && yr%100 !=0);
            case OTHER: return false;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int year = in.nextInt();
        String result = solve(year);
        System.out.println(result);
    }
}
