package maths;

/**
 * Created by liju on 8/21/17.
 * The greatest common divisor (GCD) of two numbers a and b is the greatest number that divides evenly into both a and b. Naively we could start from the smallest of the two numbers and work our way downwards until we find a number that divides into both of them
 */
public class GCD {

    int gcd(int a, int b){
        for (int i=Math.min(a,b); i>=1; i--)
            if (a%i==0 && b%i==0)
                return i;

        return 1;
    }
}
