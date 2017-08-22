package maths;

/**
 * Created by liju on 8/21/17.
 */
public class GCD_EuclidsAlgo {

    //assume that a and b cannot both be 0
    public int GCD(int a, int b)
    {
        if (b==0) return a;
        return GCD(b,a%b);
    }


    public int LCM(int a, int b)
    {
        return b*a/GCD(a,b);
    }

}
